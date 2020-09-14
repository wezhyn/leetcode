package com.wezhyn.learn.string

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

换句话说，第一个字符串的排列之一是第二个字符串的子串。

输入: s1 = "ab" s2 = "eidbaooo"
输出: True
解释: s2 包含 s1 的排列之一 ("ba").
 * @author wezhyn
 * @since 08.23.2020
 *
 */
class StringArranged {

    fun checkInclusion(s1: String, s2: String): Boolean {
        val s1Nums = IntArray(26) { 0 }
        for (c in s1) {
            s1Nums[c - 'a']++
        }
        val s2Nums = IntArray(26) { 0 }
        for (i in 0..(s2.length - s1.length)) {
            if (i == 0) {
                for (j in s1.indices) {
                    s2Nums[s2[j] - 'a']++
                }
            } else {
                s2Nums[s2[i - 1] - 'a']--
                s2Nums[s2[i + s1.length - 1] - 'a']++
            }

            if (s1Nums.contentEquals(s2Nums)) {
                return true
            }
        }
        return false
    }


}