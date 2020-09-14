package com.wezhyn.learn.lcof

/**
 *
 * @author wezhyn
 * @since 07.18.2020
 *
 */
class NumsEqualsSubscript {

    fun findSubscript(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return -1
        }
        var l = 0
        var r = nums.size - 1
        while (l <= r) {
            val middle = (l + r).div(2)
            when {
                nums[middle] == middle -> {
                    return middle
                }
                nums[middle] > middle -> {
                    r = middle - 1
                }
                nums[middle] < middle -> {
                    l = middle + 1
                }
            }
        }
        return -1
    }
}