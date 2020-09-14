package com.wezhyn.learn.lcof

/**
 * 正则表达式
 * 不使用 when 进行编写，实现逻辑细节复杂
 *
 * 使用 递归模拟一个调用栈，尝试匹配 ‘*’,失败后回退一个调用栈接着尝试
 *
 * Note: 注意 * 代表 0-n
 * ture -> s= "aab" p= "c*a*b*"
 * true -> s="a"    p="ab*"
 *
 *
 * @author wezhyn
 * @since 06.29.2020
 *
 */
class RegularExpressionMatching {


    fun isMatch(s: String, p: String): Boolean {
        return match(s, p, 0, 0)
    }

    // 检验 p 匹配完，即 s 可以会越界
    private fun match(s: String, p: String, si: Int, pi: Int): Boolean {
        if (si == s.length && pi == p.length) {
            return true
        } else if (pi >= p.length) {
            return false
        }
        val nextP = if (pi + 1 == p.length) ' ' else p[pi + 1]
        var result = false
        // aaaba  a*ba si=0 pi =0 ; 尝试结果 match(aaba,ba) || match(aba,ba) || match (ba,ba)
        if (nextP == '*') {
            for (i in si until s.length) {
                val curS = specialIndex(s, i)
                if (!curS.charMatch(p[pi])) {
                    break
                }
                result = result || match(s, p, i + 1, pi + 2)
            }
            //                跳过当前 ‘*’
            return if (result) true else match(s, p, si, pi + 2)
        } else {
            result = result || specialIndex(s, si).charMatch(p[pi])
            if (result) {
                result = result && match(s, p, si + 1, pi + 1)
            }
            return result
        }
    }

    private fun specialIndex(s: String, i: Int): Char = if (i >= s.length) ' ' else s[i]

    private fun Char.charMatch(p: Char): Boolean = if (p == '.') true else this == p
}