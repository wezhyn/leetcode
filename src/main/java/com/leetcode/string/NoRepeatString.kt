package com.leetcode.string

/**
 * 求最长不重复的连续子串长度
 * @author wezhyn
 * @since 08.23.2020
 *
 */
class NoRepeatString {

    fun lengthOfLongestSubstring(s: String): Int {
//        每一个字符前一次出现的位置
        val preIndexs = HashMap<Char, Int>()
        var max = 0
//        标识当前长度
        var cur = 0
        for ((i, c) in s.withIndex()) {
            val diff = i - preIndexs.getOrDefault(c, -1)
            when {
//                之前出现的字符在当前连续子串之前
                diff > cur -> {
                    cur++
                }
//                当前字符在 cur 的连续子串中重复
                diff < cur -> {
                    cur = diff
                }
                else -> {
//                    当前字符与cur第一个重复，省略操作
                }
            }
            preIndexs[c] = i
            max = Math.max(max, cur)
        }
        return max
    }
}