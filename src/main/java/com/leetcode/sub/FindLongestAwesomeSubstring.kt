package com.leetcode.sub

/**
 *
 * @author wezhyn
 * @since 08.19.2020
 *
 */
class FindLongestAwesomeSubstring {
    fun longestAwesome(s: String): Int {
        val idx = Array(1024) { s.length }
        idx[0] = -1
        var mask = 0
        var ans = 0
        for (i in s.indices) {
            val curDigit = s[i] - '0'
            mask = mask.xor(1.shl(curDigit))
            ans = Math.max(ans, i - idx[mask])
            for (j in 0 until 10) {
                ans = Math.max(ans, i - idx[mask.xor(1.shl(j))])
            }
            idx[mask] = Math.min(idx[mask], i)
        }
        return ans
    }
}