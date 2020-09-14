package com.wezhyn.learn.string

/**
 *
 *  找到可能的最长的回文字符串
 *  由于是原字符串的子序列组成的回文，考略从两头相等字符串开始
 *  bbbab 可以划分成如下子问题：b ... b 中 ... 最大的回文长度
 *  bba 可以划分成如下子问题：bb 子序列或者 ba 子序列
 * 最左端使用l ,最右端使用r
 *  s[l]==s[r] ,dp(l,r)=2+dp(l+1,r-1)
 *  s[l]!=s[r],dp(l,r)=Max(dp(l+1,r),dp(l,r-1)
 *
 *  aba 时 dp(1,3)=2+dp(2,2)  =2+1
 *  abc 时 dp(1,2)=Max(dp(1,2),dp(2,3)=Max( Max(dp(1,1),dp(2,2)),Max(dp(2,2),dp(2,3)) =1
 * @author wezhyn
 * @since 07.19.2020
 *
 */
class LongestPalindromicSubsequence {
    private lateinit var dp: Array<IntArray>
    fun longestPalindromeSubseq(s: String): Int {
        dp = Array(s.length) { IntArray(s.length) { -1 } }
        return dp(s, 0, s.length - 1)
    }

    private fun dp(s: String, l: Int, r: Int): Int {
        if (l > r) {
            return 0
        } else if (l == r) {
            return 1
        }
        var cache = dp[l][r]
        if (cache != -1) {
            return cache
        }
        cache = if (s[l] == s[r]) {
            2 + dp(s, l + 1, r - 1)
        } else {
            Math.max(dp(s, l + 1, r), dp(s, l, r - 1))
        }
        dp[l][r] = cache
        return cache
    }
}