package com.random

import com.leetcode.backtracking.NumbersWithSameConsecutiveDifferences
import org.junit.Assert.assertArrayEquals
import org.junit.Test

/**
 *
 * @author wezhyn
 * @since 08.19.2020
 */
class NumbersWithSameConsecutiveDifferencesTest {

    @Test
    fun numsSameConsecDiff() {
        assertArrayEquals(intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
                NumbersWithSameConsecutiveDifferences().numsSameConsecDiff(1, 1))
        assertArrayEquals(
                intArrayOf(10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98),
                NumbersWithSameConsecutiveDifferences().numsSameConsecDiff(2, 1)
        )
    }
}