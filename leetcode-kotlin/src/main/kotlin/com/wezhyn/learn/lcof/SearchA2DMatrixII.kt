package com.wezhyn.learn.lcof

/**
 *
 * @author wezhyn
 * @since 06.26.2020
 *
 */
class SearchA2DMatrixII {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty()) {
            return false
        }
        var x = 0
        var y = matrix[0].size - 1
        while (x < matrix.size && y >= 0) {
            val cur = matrix[x][y]
            if (cur > target) {
                y--
            } else if (cur == target) {
                return true
            } else {
                x++
            }
        }
        return false
    }
}