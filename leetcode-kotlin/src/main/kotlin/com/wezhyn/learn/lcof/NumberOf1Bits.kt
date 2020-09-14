package com.wezhyn.learn.lcof

/**
 *
 * 解法的确惊艳，思路如下：
 * 当 n = 1110 时， 这个数减去1 ，将使n 二进制数中最右边的1变成0 ，其后面的0变成全1 即 1101
 * 1101 & 1101 =1100 ，即-1 + & 操作使得原二进制减去了一个最后边的1
 *
 * Kotlin 位移运算操作：
 * shl << 左移 、  shr  >> 右移
 * ushr >>> 无符号右移
 * and 与
 * or 或
 * xor 异或
 * inv 非
 *
 *
 * @author wezhyn
 * @since 06.27.2020
 *
 */
class NumberOf1Bits {
    fun hammingWeight(_n: Int): Int {
        var n = _n
        var count = 0
        while (n != 0) {
            n = n.and(n - 1)
            count++
        }
        return count
    }
}