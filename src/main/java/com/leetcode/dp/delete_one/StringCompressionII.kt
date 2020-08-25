package com.leetcode.dp.delete_one

/**
 * 给定字符串，删除 k 个字符，求压缩后的最短长度
 * 由于删除先前后，删除的字符串会影响左右子串的压缩，所以dp时需要考虑
 *
 * dp(p,s,k)
 * > p: 保留的字符串 s:代删除的子串 ， k: 还需要删除几个
 *
 * dp(p,s,k) = dp(p+s[0],s[1..],k) 保留第一个字符 ||
 *             dp(p,s[1..],k-1) 删除第一个字符
 *             的最小长度
 *
 * @author wezhyn
 * @since 08.24.2020
 *
 */
class StringCompressionII {
    fun getLengthOfOptimalCompression(s: String, k: Int): Int {
        return 1
    }
}