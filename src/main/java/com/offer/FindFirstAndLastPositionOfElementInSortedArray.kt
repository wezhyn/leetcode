package com.offer

/**
 *
 * 使用两次二分查找，分别寻找最左边的元素和最右边的元素
 * @author wezhyn
 * @since 07.15.2020
 *
 */
class FindFirstAndLastPositionOfElementInSortedArray {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) {
            return intArrayOf(-1, -1)
        }
        val leftMost = searchMost(nums, 0, nums.size - 1, target, true)
        if (leftMost == -1) {
            return intArrayOf(-1, -1)
        }
        val rightMost = searchMost(nums, leftMost, nums.size - 1, target, false)
        return intArrayOf(leftMost, rightMost)
    }


    private fun searchMost(nums: IntArray, left: Int, right: Int, target: Int, leftMost: Boolean): Int {
        var l = left
        var r = right
//        退出条件：l==r
        while (l < r) {
            val middle = (l + r) / 2
            when {
                nums[middle] == target -> {
                    if (leftMost) {
                        if (middle > 0 && nums[middle - 1] == target) {
                            r = middle - 1
                        } else {
                            return middle
                        }
                    } else {
                        if (middle < r && nums[middle + 1] == target) {
                            l = middle + 1
                        } else {
                            return middle
                        }
                    }
                }
                nums[middle] > target -> {
                    r = middle - 1
                }
                nums[middle] < target -> {
                    l = middle + 1
                }
            }
        }
        return if (nums[l] == target) l else -1
    }
}