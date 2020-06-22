package com.leetcode.graph

/**
 *
 * @author wezhyn
 * @since 06.15.2020
 *
 */


class RestoreIpAddress {
    private final val partNum = 3

    fun restoreIpAddresses(s: String): List<String> {
        val result = ArrayList<String>()
        dfs(mutableListOf("", "", "", ""), s, 0, s.length, result)
        return result
    }

    fun dfs(values: MutableList<String>, str: String, part: Int, remain: Int, result: MutableList<String>) {
        if (part == partNum + 1 && remain == 0) {
//                分配结束
            char2Str(values)?.let {
                result.add(it)
            }
            return
        }
        for (i in 1..3) {
//            当前部分使用 i 个元素后,剩余的必须小于等于 (r-part)*3
            val ri = remain - i
            if (ri >= 0 && ri <= (partNum - part) * 3) {
                val start = str.length - remain
                val numStr = str.substring(start, start + i)
                valid(numStr)?.let {
                    values[part] = numStr
                    dfs(values, str, part + 1, ri, result)
                }
            }
        }
    }

    private fun valid(str: String): String? {
        if (str.length > 1 && str.startsWith("0")) {
            return null
        } else if (str.toInt() > 255) {
            return null
        }
        return str
    }

    private fun char2Str(values: List<String>): String? = values.asSequence()
            .joinToString(separator = ".") { it }

}
