package com.wezhyn.learn.lcof

/**
 *
 * @author wezhyn
 * @since 07.12.2020
 *
 */
class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        val map = HashMap<Char, Int>()
        var max = 0
        var cur = 0
        for ((i, c) in s.withIndex()) {
            val preIndex = map[c] ?: -1
            if (i - preIndex > cur) {
                cur++
            } else {
                max = Math.max(cur, max)
                cur = i - preIndex
            }
            map[c] = i
        }
        max = Math.max(cur, max)
        return max
    }
}