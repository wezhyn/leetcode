package com.wezhyn.learn.dp.limit

/**
 * O(n) 的复杂度，就需要倒过来计算
 * @author wezhyn
 * @since 06.23.2020
 *
 */
class Triangle {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        if (triangle.isEmpty()) {
            return 0
        } else if (triangle.size == 1) {
            return triangle.first().min() ?: 0
        }
        val dp = IntArray(triangle.size) { triangle.last()[it] }
        for (row in triangle.size - 2 downTo 0) {
            for (i in triangle[row].indices) {
                dp[i] = Math.min(dp[i], dp[i + 1]) + triangle[row][i]
            }
        }
        return dp[0]
    }

}