package com.random

/**
 *
 * @author wezhyn
 * @since 07.20.2020
 *
 */
class SortIntegersByTheNumberOf1Bits {
    fun sortByBits(arr: IntArray): IntArray {
        return arr.sortedWith(Comparator<Int> { t1, t2 ->
            val result = bitCount(t1) - bitCount(t2)
            if (result == 0) {
                t1 - t2
            } else {
                result
            }
        }).toIntArray()
    }

    private fun bitCount(_i: Int): Int {
        var sum = 0
        var i = _i
        while (i != 0) {
            sum++
            i = i.and(i - 1)
        }
        return sum
    }
}