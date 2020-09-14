package com.wezhyn.learn.digit

/**
 * 找到一个 Index ，使得Index左边元素之和等于 Index 右边元素之和
 * Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.
 * @author wezhyn
 * @since 08.18.2020
 *
 */
class FindPivotIndex {
    fun pivotIndex(nums: IntArray): Int {
        val totalSum = nums.sum()
        val sums = IntArray(nums.size + 1)
        for ((i, v) in nums.withIndex()) {
            sums[i + 1] = sums[i] + nums[i]
            val right = totalSum - sums[i + 1]
            if (right == sums[i]) {
                return i
            }
        }
        return -1
    }
}