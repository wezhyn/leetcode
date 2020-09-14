package com.wezhyn.learn.dp.limit

/**
 * 可以得知 dp(i)[0] 表示当前(i)所在的是 一字形
 * dp(i)[1] 是凸字形
 * @author wezhyn
 * @since 07.24.2020
 *
 */
class DominoAndTrominoTiling {
    private lateinit var cache: Array<IntArray>
    fun numTilings(N: Int): Int {
        cache = Array(N + 2) { IntArray(2) { 0 } }
        cache[1][0] = 1
        cache[2][0] = 2
        cache[2][1] = 1
        return dp(N, 0)
    }

    private fun dp(i: Int, y: Int): Int {
        var num = cache[i][y].toLong()
        if ((i > 2 && num != 0L) || i <= 2) {
            return num.toInt()
        }
        when (y) {
            0 -> {
                num = dp(i - 1, 0).toLong() + dp(i - 2, 0) + 2 * dp(i - 1, 1)
            }
            1 -> {
                num = dp(i - 1, 1).toLong() + dp(i - 2, 0)
            }
        }
        num = num.rem(1000000007)
        cache[i][y] = num.toInt()
        return cache[i][y]
    }
}