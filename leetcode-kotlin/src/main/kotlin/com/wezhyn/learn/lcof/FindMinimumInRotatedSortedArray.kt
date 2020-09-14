package com.wezhyn.learn.lcof

/**
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * Find the minimum element.
 *
 * 原数组是递增的，所以在某一个位置点旋转后，其变成了两个递增的子序列，根据二分的思想， l=arr[0] , r=arr[arr.size-1]
 * mid 如果小于 r ，即第二个递增的子序列，则代表 mid-r 这个区间是一个单调递增区间，将 r=mid
 * mid 如果等于r，当前是一个重复元素，mid既可能在第一个递增数组上，也可能在第二个递增数组上, 由于 mid==r ，所以最后一个元素可能不大可能为最小值，尝试r--
 * mid 大于r，代表处于第一个递增子数组，l=mid+1
 *
 *
 * @author wezhyn
 * @since 06.26.2020
 *
 */
class FindMinimumInRotatedSortedArray {


    fun findMinSimple(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var l = 0
        var r = nums.size - 1

        while (l < r) {
            val mid = l + (r - l) / 2
            when {
                (nums[mid] < nums[r]) -> r = mid
                (nums[mid] > nums[r]) -> l = mid + 1
                else -> r--
            }
        }

        return nums[l]
    }

    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1
        while (l < r) {
            val m = (l + r).ushr(1)
            val mid = nums[m]
            val left = nums[l]
            val right = nums[r]
            if (left < right) {
                return left
            }
            if (mid > left && mid < right) {
//                mid 位于第二个递增序列
                r = m
            } else if (mid > left && mid > right) {
//                mid 位于第一个递增序列
                l = m + 1
            } else if (mid < left && mid > right) {
//                第一个序列
                l = m + 1
            } else if (mid < left && mid < right) {
//                第二个序列
                r = m
            } else {
                r--
            }
        }
        return nums[r]
    }
}