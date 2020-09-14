package com.wezhyn.learn.lcof

/**
 *
 * 将一段长度为n 的绳子，切分成 m 段，切分下来的为整数长度
 * @author wezhyn
 * @since 06.27.2020
 *
 */
class CutCord {

    private lateinit var dp: Array<Array<Int?>>

    fun cur(n: Int, m: Int): Int {
//        dp[n][m] 代表 5米，割两次最大值是多少
        dp = Array(n + 1) { arrayOfNulls<Int?>(m + 1) }
        return dp(n, m)

    }

    private fun dp(n: Int, m: Int): Int {
        if (m > n) {
//            2
            return 0
        }
        if (m == 1) {
            return n
        }
        val cache = dp[n][m]

        if (cache == null) {
            var max = Int.MIN_VALUE
            for (i in 1..n - m + 1) {
                max = Math.max(max, i * dp(n - i, m - 1))
            }
            dp[n][m] = max
            return max
        } else {
            return cache
        }

    }

}