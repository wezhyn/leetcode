package com.wezhyn.learn.graph

/**
 *
 *
 * 一种节点上下左右走动的示例代码:
 *
 * offset= { 0，-1，0，1，0 }
 *
 * 从 i 开始， x + offset[ i ] ,y + offset[ i+1 ]
 * 第一轮： (x,y-1)
 * 第二轮： (x-1,y)
 * 第三轮： (x,y+1)
 * 第四轮： (x+1,y)
 *
 * 给定一个二维数组，求最大递增路径的长度
 *
 * @author wezhyn
 * @since 06.22.2020
 *
 */
class LongestIncreasingPathInAMatrix {

    /**
     * -1 代表还未开始
     *
     */
    companion object {
        val offset = intArrayOf(0, -1, 0, 1, 0)
    }

    private lateinit var dp: Array<IntArray>
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        dp = Array(matrix.size) { IntArray(matrix[it].size) { -1 } }
        var max = Int.MIN_VALUE
        for ((i, arr) in dp.withIndex()) {
            for ((j, v) in arr.withIndex())
                if (v < 0) {
                    max = Math.max(max, dfsPath(matrix, i, j))
                }
        }
        return if (max == Int.MIN_VALUE) {
            0
        } else {
            max
        }
    }

    private fun dfsPath(matrix: Array<IntArray>, i: Int, j: Int): Int {

        if (dp[i][j] > 0) {
            return dp[i][j]
        }
        var max = 1
        for (of in 0..3) {
            val xi = i + offset[of]
            val yi = j + offset[of + 1]
            if (xi < 0 || yi < 0 || xi >= matrix.size || yi >= matrix[xi].size) {
                continue
            }
            if (matrix[i][j] < matrix[xi][yi]) {
                max = Math.max(max, 1 + dfsPath(matrix, xi, yi))
            }
        }
        dp[i][j] = max
        return max
    }

}