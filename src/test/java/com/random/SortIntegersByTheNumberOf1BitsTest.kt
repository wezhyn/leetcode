package com.random

import org.junit.Assert.assertArrayEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.20.2020
 */
class SortIntegersByTheNumberOf1BitsTest {

    @ExperimentalStdlibApi
    @Test
    fun sortByBits() {
        assertArrayEquals(intArrayOf(0, 1, 2, 4, 8, 3, 5, 6, 7),
                SortIntegersByTheNumberOf1Bits().sortByBits(intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8)))
    }
}