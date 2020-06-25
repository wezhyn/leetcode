package com.leetcode.dp

/**
 * 二维矩形求和
 * @author wezhyn
 * @since 06.25.2020
 *
 */
class NumMatrix(matrix: Array<IntArray>) {

    /**
     * 代表(0,0)到当前位置的和
     */
    private val sum: Array<IntArray> = Array(matrix.size) { IntArray(matrix[it].size) }

    init {
        for (x in matrix.indices) {
            var rowSum = 0
            for (y in matrix[x].indices) {
                rowSum += matrix[x][y]
                sum[x][y] = rowSum + if (x == 0) 0 else {
                    sum[x - 1][y]
                }
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return sum[row2][col2] - if (col1 == 0) 0 else {
            sum[row2][col1 - 1]
        } - if (row1 == 0) 0 else {
            sum[row1 - 1][col2]
        } + if (col1 == 0 || row1 == 0) 0 else {
            sum[row1 - 1][col1 - 1]
        }
    }
}