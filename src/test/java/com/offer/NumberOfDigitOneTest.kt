package com.offer

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.09.2020
 */
class NumberOfDigitOneTest {

    @Test
    fun countDigitOne() {
        assertEquals(1640, NumberOfDigitOne().countDigitOne(2113))
        assertEquals(454, NumberOfDigitOne().countDigitOne(1113))
        assertEquals(448, NumberOfDigitOne().countDigitOne(1111))
        assertEquals(656, NumberOfDigitOne().countDigitOne(1211))
        assertEquals(658, NumberOfDigitOne().countDigitOne(1212))
        assertEquals(6, NumberOfDigitOne().countDigitOne(13))
    }
}