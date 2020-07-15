package com.offer


/**
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * ugly= 2^i*3^j*5^k
 *  1 是特殊的丑数
 *
 */
class UglyNumber {
    fun isUgly(_n: Int): Boolean {
        var num = _n
        if (num == 0) return false
        val factories = intArrayOf(2, 3, 5)
        for (f in factories) {
            while (num.rem(f) == 0) {
                num /= f
            }
        }
        return num == 1
    }
}

/**
 * 如何计算丑数：2^i3^j5^y
 * 通过保存之前的丑数 [ugly1,ugly2,ugly3...uglyn]
 * 当前的最大丑数为M
 * 那么下一个丑数就会是 2* uglyi| 3* uglyj | 5 * uglyk 最小的一个
 * 当下一个丑数为 3* uglyj 时，表示 uglyj 要变成下一个丑数，才能使得 2* uglyi 有机会成为下一个
 *
 * @author wezhyn
 * @since 07.14.2020
 *
 */
class UglyNumberII {
    fun nthUglyNumber(n: Int): Int {
        val nums = ArrayList<Int>().apply { add(1) }
//        最小丑数为 0，i2=i3=i5=0
        var i2 = 0
        var i3 = 0
        var i5 = 0
        while (nums.size < n) {
            val next2 = 2 * nums[i2]
            val next3 = 3 * nums[i3]
            val next5 = 5 * nums[i5]
            val next = Math.min(Math.min(next2, next3), next5)
            if (next2 == next) i2++
            if (next3 == next) i3++
            if (next5 == next) i5++
            nums.add(next)
        }
        return nums[n - 1]
    }
}