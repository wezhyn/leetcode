package com.wezhyn.learn.dp

/**
 * dp[i] 保存最大值，当变成负数时清空
 * @author wezhyn
 * @since 06.24.2020
 *
 */
class MaximumSubarray {
    fun maxSubArray(nums: IntArray): Int {
//
        val dp = IntArray(nums.size)
        for (i in nums.indices) {
            dp[i] = nums[i] + Math.max(0, getDp(dp, i - 1))
        }
        return dp.max() ?: Int.MIN_VALUE

    }

    private fun getDp(dp: IntArray, i: Int): Int {
        if (i < 0 || i >= dp.size || dp[i] < 0) {
            return -1
        }
        return dp[i]
    }
}