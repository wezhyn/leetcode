package com.offer

import com.swap

/**
 * 给定一个数组，有一个元素出现的次数超过了数组长度的一半
 *
 *
 * 1. 使用传统的算法进行排序 O(nLogn)
 * 2. 当一个元素次数操作数组长度一半后，其最中间的元素即为这个重复元素【中位数】，可以使用 Partition算法，查找中位数
 * 3. 遍历数组，将元素和次数进行保存，num[i] -> result[i]++ ,时间复杂度 O(n) ，空间复杂度O(n)
 * 4. 分析(3) num[] 数组中，0-n-1 个元素中，最大的num[i] > sum(num[other]),使用一个 num 和一个 values 可以缩小空间的复杂度
 *
 *
 *
 * @author wezhyn
 * @since 07.01.2020
 *
 */
class MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        partition(nums, 0, nums.size - 1)
        return nums[nums.size.ushr(1)]
    }

    private fun partition(nums: IntArray, l: Int, r: Int) {
        if (l >= r) {
            return
        }

        val medium = doPartition(nums, l, r)
        val m = nums.size.ushr(1)
        when {
            medium < m -> {
                partition(nums, medium + 1, r)
            }
            medium == m -> {

            }
            medium > m -> {
                partition(nums, l, medium - 1)
            }
        }

    }

    private fun doPartition(nums: IntArray, l: Int, r: Int): Int {
        if (l >= r) {
            return l
        }
        val flag = nums[l]
//        指向下一个，[l,medium) 小于 flag
        var medium = l + 1
        for (i in l + 1..r) {
            when (nums[i] <= flag) {
                true -> {
                    nums.swap(medium++, i)
                }
                else -> {
                }
            }
        }
        nums.swap(l, medium - 1)
        return medium - 1
    }
}
