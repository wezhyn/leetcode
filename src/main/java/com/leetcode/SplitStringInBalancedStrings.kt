package com.leetcode

/**
 * 双指针
 * @author wezhyn
 * @since 06.17.2020
 *
 */
class SplitStringInBalancedStrings {
    fun balancedStringSplit(s: String): Int {
        var l = 0
        var r = 0
        var count = 0
        for (c in s) {
            if (c == 'R') {
                r++
            } else {
                l++
            }
            if (r == l) {
                count++
            }
        }
        return count
    }
}