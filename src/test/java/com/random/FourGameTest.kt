package com.random

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.21.2020
 */
class FourGameTest {

    @Test
    fun divide() {
        println(4 / (1 - 2 / 3))
        println(4.0 / (1.0 - 2.0 / 3.0))
    }

    @Test
    fun judgePoint24() {
        assertTrue(FourGame().judgePoint24(intArrayOf(1, 9, 1, 2)))
        assertTrue(FourGame().judgePoint24(intArrayOf(1, 3, 4, 6)))
        assertTrue(FourGame().judgePoint24(intArrayOf(1, 1, 3, 120)))
        assertTrue(FourGame().judgePoint24(intArrayOf(1, 1, 3, 120)))
        assertTrue(FourGame().judgePoint24(intArrayOf(4, 1, 8, 7)))
        assertFalse(FourGame().judgePoint24(intArrayOf(1, 2, 1, 2)))
    }
}