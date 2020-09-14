package com.wezhyn.learn.lcof

import java.util.*

/**
 *
 * 注意边界值：
 * [0,0]
 * 824 > 8247
 * @author wezhyn
 * @since 07.11.2020
 *
 */
class LargestNumber {
    fun largestNumber(nums: IntArray): String {
//        转化成字符串列表，排序，拼接
        val result = nums.asSequence()
                .map { it.toString() }
                .sortedWith(Comparator { s1: String, s2: String ->
                    val first = s1 + s2
                    val second = s2 + s1
                    return@Comparator second.compareTo(first)
                })
                .joinToString(separator = "")
        if (result.startsWith("0")) {
            return "0"
        } else {
            return result
        }
    }
}