package com.offer

import com.intArray
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.14.2020
 */
class ReversePairsTest {

    @Test
    fun reversePairs() {
        assertEquals(9, ReversePairs().reversePairs("1,-4,-6,2,4,-3,2,3,1".intArray()))
        assertEquals(3, ReversePairs().reversePairs("2,4,3,5,1".intArray()))
        assertEquals(1, ReversePairs().reversePairs("-5,-5".intArray()))
        assertEquals(2, ReversePairs().reversePairs("1,3,2,3,1".intArray()))
    }
}