package com.offer

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.27.2020
 */
class NumberOf1BitsTest {

    @Test
    fun hammingWeight() {
        assertEquals(1, NumberOf1Bits().hammingWeight(1))
        assertEquals(1, NumberOf1Bits().hammingWeight(2))
        assertEquals(2, NumberOf1Bits().hammingWeight(3))
        assertEquals(4, NumberOf1Bits().hammingWeight(15))
    }
}