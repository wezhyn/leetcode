package com.wezhyn.learn.lcof

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.09.2020
 */
class NthDigitTest {

    @Test
    fun findNthDigit() {
        assertEquals(2, NthDigit().findNthDigit(2147483647))
        assertEquals(1, NthDigit().findNthDigit(190))
        assertEquals(4, NthDigit().findNthDigit(99))
        assertEquals(1, NthDigit().findNthDigit(10))
        assertEquals(0, NthDigit().findNthDigit(11))
        assertEquals(1, NthDigit().findNthDigit(13))
        assertEquals(3, NthDigit().findNthDigit(3))
    }
}