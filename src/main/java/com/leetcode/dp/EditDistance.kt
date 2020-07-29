package com.leetcode.dp

/**
 *

 * 使用dp(i)(j) 代表 word1[0-i] - word2[0-j] 变化多少次
 * word1[0-i] 最坏情况下经过最多 i 次 一定能变化成 word2[0-i]
 * word1: horse word2:ros
 * dp(0,0) 一定最大为1，最小为0 dp(0,0)=1
 * dp(0,i) i>0 则为 Min dp(0,0) +i
 * dp(1,0) 代表 remove word1[0] + 变化一次 最小为1 最大为 2 即 dp(1,0)= 2
 * dp(1,1) 为 Min(dp(0,0) dp(1,0))+ word1[1] 与 word2[1]
 *
 * first submit ： sea -> eat
 * second submit: teacher -> tepache -> 即 eat -> sea
 *
 * > https://www.youtube.com/watch?v=Q4i_rqON2-E 预先填充 0 ，避免了复杂考虑
 * @author wezhyn
 * @since 07.25.2020
 *
 */
class EditDistance {
    fun minDistance(word1: String, word2: String): Int {
//        初始化 dp[i][0] "aaa" -> "" 和 dp[0][i] “” -> "aaa"  i,j 从1开始
        val dp = Array(word1.length + 1) { IntArray(word2.length + 1) }
        for (i in 0..word1.length) {
            dp[i][0] = i
        }
        for (j in 0..word2.length) {
            dp[0][j] = j
        }
        for (i in 1..word1.length) {
            for (j in 1..word2.length) {
                val isEquals = if (word1[i - 1] == word2[j - 1]) 0 else 1
//                    hoh -> hh hhh -> hh  hjk -> hi hijl -> ijx hijl -> ijl  ijkl -> ijk
                dp[i][j] = Math.min(
                        Math.min(dp[i - 1][j - 1] + isEquals, dp[i][j - 1] + 1),
                        dp[i - 1][j] + 1
                )
            }
        }
        return dp[word1.length][word2.length]
    }
}