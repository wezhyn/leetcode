package com.wezhyn.learn.string

/**
 * @see com.leetcode.top.interview.easy.LongestCommonPrefix 分治法处理，小任务处理组内最长长度
 *
 * @author wezhyn
 * @since 08.23.2020
 *
 */
class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        return backtracking(strs, 0)
    }

    private fun backtracking(strs: Array<String>, index: Int): String {
        if (strs.isEmpty()) {
            return ""
        }
        var cur: Char? = null
        for (s in strs) {
            if (index >= s.length) {
                return ""
            }
            if (cur == null) {
                cur = s[index]
            } else {
                if (cur != s[index]) {
                    return ""
                }
            }
        }
        return cur!! + backtracking(strs, index + 1)
    }
}