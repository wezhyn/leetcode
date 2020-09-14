package com.wezhyn.learn.array

/**
 * 找到一个连续子数组，使得子数组和为 nK
 *
 * Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 * 注意： k==0 -> X mod k 会抛出 /Zero Exception
 * 注意 sums[i]==sums[i-1] 即{0，1，0} -> sum{0,1,1}
 * nk 必须 >k
 * @author wezhyn
 * @since 08.18.2020
 *
 */
class ContinuousSubarraySum {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val sums = IntArray(nums.size + 1)
        for ((i, v) in nums.withIndex()) {
            sums[i + 1] = sums[i] + nums[i]
        }
        for (i in 1 until sums.size - 1) {
            for (j in i + 1 until sums.size) {
                val s = sums[j] - sums[i] + nums[i - 1]
                if (k == 0 && (s == 0) && nums[i - 1] == 0 && nums[j - 1] == 0) {
                    return true
                } else if (k != 0 && s % k == 0) {
                    return true
                }
            }
        }
        return false
    }
}