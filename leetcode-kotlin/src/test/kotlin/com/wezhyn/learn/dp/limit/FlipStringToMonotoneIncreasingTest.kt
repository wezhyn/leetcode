package com.wezhyn.learn.dp.limit

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.24.2020
 */
class FlipStringToMonotoneIncreasingTest {

    @Test
    fun minFlipsMonoIncr() {
        assertEquals(2, FlipStringToMonotoneIncreasing().minFlipsMonoIncr("00011010"))
        assertEquals(1, FlipStringToMonotoneIncreasing().minFlipsMonoIncr("00110"))
        assertEquals(2, FlipStringToMonotoneIncreasing().minFlipsMonoIncr("010110"))
        assertEquals(2, FlipStringToMonotoneIncreasing().minFlipsMonoIncr("00011000"))
    }
}