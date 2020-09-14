package com.wezhyn.learn.lcof

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.14.2020
 */
class UglyNumberIITest {

    @Test
    fun nthUglyNumber() {
        assertEquals(1, UglyNumberII().nthUglyNumber(1))
        assertEquals(2, UglyNumberII().nthUglyNumber(2))
        assertEquals(12, UglyNumberII().nthUglyNumber(10))
    }
}