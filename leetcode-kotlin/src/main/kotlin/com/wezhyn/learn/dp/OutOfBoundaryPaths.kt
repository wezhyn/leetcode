package com.wezhyn.learn.dp

/**
 * dp[k][i][j] 代表 走 k 步 到达 目标 Arr[i,j] 有多少种走法
 * > 从边界外向 i,j 进行k步
 * 场外到场内 = 1
 * 场内 = k-1 步上下左右相加
 *
 * @author wezhyn
 * @since 07.29.2020
 *
 */
class OutOfBoundaryPaths {

    fun findPaths(m: Int, n: Int, N: Int, i: Int, j: Int): Int {
//        从场外任意一点到达边界只有一种走法
        val dp = Array(N + 1) { Array(m) { IntArray(n) } }
        for (k in 1..N) {
            for (mi in 0 until m) {
                for (mj in 0 until n) {
                    dp[k][mi][mj] = (getDp(dp, k - 1, mi - 1, mj).toLong() + getDp(dp, k - 1, mi + 1, mj) +
                            getDp(dp, k - 1, mi, mj - 1) + getDp(dp, k - 1, mi, mj + 1)).rem(1000000007).toInt()
                }
            }
        }
        return dp[N][i][j]
    }

    private fun getDp(dp: Array<Array<IntArray>>, k: Int, i: Int, j: Int): Int {
        if (k < 0 || i < 0 || j < 0 || i >= dp[k].size || j >= dp[k][i].size) {
            return 1
        }
        return dp[k][i][j]
    }


}