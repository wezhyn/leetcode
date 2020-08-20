package com.leetcode.bs

/**
 *Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * 使用值二分的思想
 * @author wezhyn
 * @since 08.19.2020
 *
 */
class Sqrt {
    fun mySqrt(x: Int): Int {
        var l = 1
        var r = x
        while (l <= r) {
            val middle = l + (r - l) / 2
            val dm = middle * middle.toLong()
            if (dm <= 0) {
                r = middle - 1
                continue
            }
            if (dm > x) {
                r = middle - 1
            } else if (dm == x.toLong()) {
                return middle
            } else {
                l = middle + 1
            }
        }
        return r
    }

}