package com.wezhyn.learn.dp

/**
 *
 * 方法1：常规思路，遍历每个点，检查当前点的最大 Square 面积，难点在于如何在O(1)的时间判断是不是 Square
 *  使用sum[x,y] 表示(0,0)到当前x,y的点和， 检查(x1,y1) -> (x2,y2) 之间是不是全为1，可以通过检查两个点之间的 sum差值来判断
 *
 *  方法2：观察图形，每一个划分出来的 square，其右边，下面，右下方也一定是一个 square的一部分，
 *  假设当前位于 (0,1) ，其左边的(0,2)是一个最大面积为4的正方形，(1,1)是一个最大为1的正方形，(1,2)是一个最大为1的正方形，
 *  以此类推
 *  dp(x,y)=Math.min(dp(x+1,y),dp(x,y+1),dp(x+1,y+1))+1
 *
 *
 *
 * @author wezhyn
 * @since 06.25.2020
 *
 */
class MaximalSquare {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return 0
        }
        return maximalSquareWithDp(matrix)
    }

    private fun maximalSquareWithDp(matrix: Array<CharArray>): Int {
        val area = Array(matrix.size) { IntArray(matrix[it].size) { 0 } }
        val getArea = { x: Int, y: Int -> if (x >= matrix.size || y >= matrix[x].size) 0 else area[x][y] }
        for (row in matrix.indices.reversed()) {
            for (column in matrix[row].indices.reversed()) {
                if (matrix[row][column] == '1')
                    area[row][column] = Math.min(Math.min(getArea(row + 1, column), getArea(row, column + 1)),
                            getArea(row + 1, column + 1)) + 1
            }
        }
        val maxLen = area.maxBy { it.max() ?: 0 }!!.max() ?: 0
        return maxLen * maxLen
    }


    private fun maximalSquareWithSum(matrix: Array<CharArray>): Int {
        val sum = Array(matrix.size) { IntArray(matrix[it].size) };
        for (i in matrix.indices) {
            var tmpRow = 0
            for (j in matrix[i].indices) {
                tmpRow += matrix[i][j] - '0'
                sum[i][j] = tmpRow + if (i == 0) 0 else sum[i - 1][j]
            }
        }
        var maxArea = 0
        val rowLen = matrix.size - 1
        for (i in matrix.indices) {
            val columnLen = matrix[i].size - 1
            for (j in matrix[i].indices) {
                val curMaxSide = Math.min(columnLen - j, rowLen - i)
                if (matrix[i][j] == '0' || (curMaxSide + 1) * (curMaxSide + 1) <= maxArea) {
                    continue
                }
//               检查当前点开始的Square 是否能够更大
                for (l in Math.sqrt(maxArea.toDouble()).toInt()..curMaxSide) {
                    val xi = i + l
                    val yj = j + l
//                    yi 一定满足要求
                    if (xi > rowLen) {
                        break
                    }
                    val squareSum = sum[xi][yj] - if (j == 0) 0 else {
                        sum[xi][j - 1]
                    } - if (i == 0) 0 else {
                        sum[i - 1][yj]
                    } + if (i == 0 || j == 0) 0 else {
                        sum[i - 1][j - 1]
                    }
                    if (squareSum == (l + 1) * (l + 1) && squareSum > maxArea) {
                        maxArea = squareSum
                    } else {
                        break
                    }
                }
            }
        }
        return maxArea
    }
}