package com.wezhyn.learn.daily

/**
 *
 * @author wezhyn
 * @since 08.16.2020
 *
 */
class UniquePaths {
    companion object {
        private val offset = intArrayOf(1, 0, 1)
    }

    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) }
        dp[m - 1][n - 1] = 1

        for (i in m - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                for (k in 0..1) {
                    val x = i + offset[k]
                    val y = j + offset[k + 1]
                    if (x >= m || y >= n) {
                        continue
                    }
                    dp[i][j] += dp[x][y]
                }
            }
        }
        return if (dp[0][0] < 0) 2000000000 else dp[0][0]
    }
}