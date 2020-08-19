package com.leetcode.sub

/**
 * 求一个数组的子数组 利用额外的O(n) 将原本的 O(n<sub>2</sub>) -> O(n)
 * Given an array of integers and an integer k,
 * you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *
 * @author wezhyn
 * @since 08.18.2020
 *
 */
class SubArraySumEqualsK {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val sums = IntArray(nums.size + 1)
//        某个sum 在 iTh 前一共有几个
        val map = HashMap<Int, Int>()
        map[0] = 1
        var result = 0
        for ((i, v) in nums.withIndex()) {
            sums[i + 1] = sums[i] + v
            result += map.getOrDefault(sums[i + 1] - k, 0)
            map[sums[i + 1]] = map.getOrDefault(sums[i + 1], 0) + 1
        }
        return result
    }
}