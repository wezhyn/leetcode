package com.offer

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.14.2020
 */
class UglyNumberTest {

    @Test
    fun isUgly() {
        assertTrue(UglyNumber().isUgly(4))
        assertTrue(UglyNumber().isUgly(1))
        assertTrue(UglyNumber().isUgly(2))
        assertTrue(UglyNumber().isUgly(3))
        assertTrue(UglyNumber().isUgly(5))
        assertTrue(UglyNumber().isUgly(6))
        assertFalse(UglyNumber().isUgly(7))
        assertTrue(UglyNumber().isUgly(8))
        assertTrue(UglyNumber().isUgly(9))
        assertTrue(UglyNumber().isUgly(10))
        assertFalse(UglyNumber().isUgly(11))
    }
}