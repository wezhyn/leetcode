package com.wezhyn.learn.lcof

/**
 * 一个有效的数字有如下的组成部分 [+|-]整数[.整数][e整数] || [+|-].整数[e整数]
 * 题目简单，甚在测试条件考虑多
 *
 * 目前未考虑到：
 * 6—1
 * 4e+
 * @author wezhyn
 * @since 06.29.2020
 *
 */
class ValidNumber {
    fun isNumber(s: String): Boolean {
        if (s.isEmpty()) {
            return false
        }
        return match(s.trim(), 0, false, false, false, false)
    }


    private fun match(s: String, si: Int, hasSymbol: Boolean, hasDecimal: Boolean, hasIndex: Boolean, _hasNumber: Boolean): Boolean {
        var hasNumber = _hasNumber
        for (i in si until s.length) {
            val cur = s[i]
            when (cur) {
                '.' -> {
                    return if (hasDecimal || hasIndex) false else match(s, i + 1, hasDecimal, true, hasIndex, hasNumber)
                }
                '+', '-' -> {
                    return if (hasSymbol || hasDecimal || hasIndex || hasNumber) false else match(s, i + 1, true, hasDecimal, hasIndex, hasNumber)
                }
                'e' -> {
                    if (i + 1 == s.length || !hasNumber) {
                        return false
                    }
//                    xe[+|-]x
                    if (s[i + 1] == '+' || s[i + 1] == '-') {
                        return if (hasIndex) false else match(s, i + 2, hasSymbol, hasDecimal, true, false)
                    }
                    return if (hasIndex) false else match(s, i + 1, hasSymbol, hasDecimal, true, hasNumber)
                }
                else -> {
                    if (!cur.isDigit()) {
                        return false
                    }
                    hasNumber = true
                }
            }
        }
        return hasNumber
    }
}