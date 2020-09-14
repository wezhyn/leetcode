package com.wezhyn.learn.lcof

/**
 * 给定一个n，查找123456789101112...n种第 nth 所在的数字
 *
 * 1 位数：1-9 9*1 9
 * 2 位数 10-99 90*2 180+9
 * 3 位数 100-999 900*3 2700+180+9
 * 4 位数 1000-9999 9000*4
 *
 * @author wezhyn
 * @since 07.09.2020
 *
 */
class NthDigit {

    private val cache = HashMap<Int, Long>()

    fun findNthDigit(_n: Int): Int {
        val n = Math.abs(_n)
        var bitIndex = 1
        while (true) {
            if (n <= maxDigit(bitIndex)) {
                break
            }
            bitIndex++
        }
        val baseN = n - maxDigit(bitIndex - 1) - 1
//        baseN 从0开始 1：1-9 2：10-189
        val numTh = baseN / bitIndex
        val num = Math.pow(10.0, (bitIndex - 1).toDouble()).toInt() + numTh

        val char = num.toString()[(baseN % bitIndex).toInt()]
        return char - '0'
    }

    /**
     * @param 1: 9;2 :99
     */
    private fun pow(y: Int): Long = Math.pow(10.0, y.toDouble()).toLong()

    private fun maxDigit(index: Int): Long {
        if (index == 1) {
            return 9
        } else if (index < 1) {
            return 0
        }
        return cache.getOrPut(index) {
//            例如 99-9 一共90个 2两位数 999-99一共900个三位数

            val result = 9 * pow(index - 1) * index + maxDigit(index - 1)
            if (result < 0) {
                Long.MAX_VALUE
            } else {
                result
            }
        }
    }

}