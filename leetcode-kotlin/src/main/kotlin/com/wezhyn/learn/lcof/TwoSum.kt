package com.wezhyn.learn.lcof

/**
 * 题为 剑指Offer 57的变种
 * a+b=target
 * leetcode 为无序数组
 *      由于两数互补，故而使用额外空间保存a，当访问到b时，需要使用O(1) 时间得知是否有 a对应的元素，故而采用HashMap作为额外空间
 * 剑指Offer 为有序递增数组
 *      由于数组单调递增，使用双指针进行处理
 * @author wezhyn
 * @since 07.18.2020
 *
 */
class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for ((i, n) in nums.withIndex()) {
            val other = target - n
            val otherIndex = map[other]
            if (otherIndex == null) {
                map[n] = i
            } else {
                return intArrayOf(otherIndex, i)
            }
        }
        return intArrayOf(-1, -1)
    }

    fun twoAscSum(nums: IntArray, target: Int): IntArray {
        if (nums.size <= 1) {
            return intArrayOf(-1, -1)
        }
        var l = 0
        var r = nums.size - 1
        while (l < r) {
            val sum = nums[l] + nums[r]
            when {
                sum == target -> {
                    return intArrayOf(l, r)
                }
                sum > target -> {
                    r--
                }
                sum < target -> {
                    l++
                }
            }
        }
        return intArrayOf(-1, -1)
    }
}