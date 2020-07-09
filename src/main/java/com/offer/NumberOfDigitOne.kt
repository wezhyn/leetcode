package com.offer

/**
 * 题目： 给一个n 求 1.. n 中 1出现的次数
 * 思路：划分区间
 * 假设 n = 12X4
 *
 * 当十位为3时 即  1234， 有   [[1x] ,[x1x], [xx1x]] 有 10 +12*10=130
 * 当十位为1时，即 1214  [[10,11,12,13,14] ,[x1x], [xx1x]] 有 5 +11*10=115
 * 当十位为0时，即 1204 有 [x1x],[xx1x] 即 11 * 10 =110
 *
 * 每一位的划分需要考虑 0,1,other 三种情况
 *
 * @author wezhyn
 * @since 07.09.2020
 *
 */
class NumberOfDigitOne {
    fun countDigitOne(n: Int): Int {
        if (n < 0) {
            return 0
        }
        val nStr = n.toString(10)
        var result = 0
        for (i in nStr.indices) {
            result += calculate(nStr.toCharArray(), i)
        }
        return result
    }

    private fun calculate(nums: CharArray, index: Int): Int {
        val curChar = nums[index]
        val left = renderNum(nums, 0, index - 1)
        val maxRight = nums.size - 1
        val right = renderNum(nums, index + 1, maxRight)
        val basePow = Math.pow(10.toDouble(), (maxRight - index).toDouble()).toInt()
        when (curChar) {
            '0' -> {
                return left * basePow
            }
            '1' -> {
                return left * basePow + right + 1
            }
            else -> {
                return (left + 1) * basePow
            }
        }
    }

    private fun renderNum(numArray: CharArray, left: Int, right: Int): Int {
        if (left < 0 || right < 0 || left >= numArray.size || right >= numArray.size) {
            return 0
        }
        var result = 0
        for (i in left..right) {
            result = result * 10 + (numArray[i] - '0')
        }
        return result
    }
}