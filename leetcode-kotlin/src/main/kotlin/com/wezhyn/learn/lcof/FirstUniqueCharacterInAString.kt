package com.wezhyn.learn.lcof

/**
 *
 * @author wezhyn
 * @since 07.14.2020
 *
 */
class FirstUniqueCharacterInAString {
    fun firstUniqChar(s: String): Int {
        val count = HashMap<Char, Int>()
        s.forEach { c -> count.put(c, count.getOrDefault(c, 0) + 1) }
        for (i in s.indices) {
            if (count[s[i]] == 1) {
                return i
            }
        }
        return -1
    }
}