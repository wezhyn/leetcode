package com.offer

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.12.2020
 */
class DecodeWaysTest {

    @Test
    fun numDecodings() {
        assertEquals(1, DecodeWays().numDecodings("10"))
        assertEquals(0, DecodeWays().numDecodings("01"))
        assertEquals(0, DecodeWays().numDecodings("02"))
        assertEquals(15, DecodeWays().numDecodings("112341012320"))
        assertEquals(0, DecodeWays().numDecodings("112340012320"))
        assertEquals(1, DecodeWays().numDecodings("1"))
        assertEquals(0, DecodeWays().numDecodings("1001"))
        assertEquals(0, DecodeWays().numDecodings("12340"))
        assertEquals(0, DecodeWays().numDecodings("0"))
        assertEquals(3, DecodeWays().numDecodings("1234"))
        assertEquals(3, DecodeWays().numDecodings("226"))
    }
}