package com.offer

/**
 * 剑指 Offer 第三题，给定一个数组，长度为n，数组内数字在 0-n-1 , 找出数组中 **任意一个重复的数字**
 *
 * 思路：一个一维数组arr，如果数组元素没有重复的，再排序后，arr[ i ] 将等于 i 【注意 数字范围在 n-1 范围内】，
 * 而题目是找出一个重复的数字，可以使用选择排序的思路，遍历的过程中，排序整个数组，当遇到重复的元素停止
 *
 * Example：
 * 【2，3，1，0，2，5，3】
 * arr[ 0 ] 为2 替换 arr[2] -> [1,3,2,0,2,5,3]
 * 接着替换 arr[1] -> [3,1,2,0,2,5,3]
 * 在替换 arr[3] -> [0,1,2,3,2,5,3]
 *
 * 接着顺序遍历到 arr[4] ，其值为 2 ，arr[2]已经为2，可以判断当前元素为重复
 * @author wezhyn
 * @since 06.26.2020
 *
 */
class DuplicateNumber {


    fun duplicateOneNotModify(numbers: IntArray): Int {
        if (numbers.size <= 1) {
            return numbers.max() ?: -1
        }
        var i = 0
        while (i < numbers.size) {
            val cur = numbers[i]
            val target = numbers[cur]
            when (cur) {
                i -> {
                    i++
                }
                target -> {
                    return cur
                }
                else -> {
                    numbers[cur] = cur
                    numbers[i] = target
                }
            }
        }
        return -1
    }
}