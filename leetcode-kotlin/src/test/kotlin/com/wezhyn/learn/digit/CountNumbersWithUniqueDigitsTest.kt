package com.wezhyn.learn.digit

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.25.2020
 */
class CountNumbersWithUniqueDigitsTest {

    @Test
    fun countNumbersWithUniqueDigits() {
        assertEquals(1, CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(0))
        assertEquals(91, CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(2))
        assertEquals(10, CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(1))
        assertEquals(32491, CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(5))
    }
}