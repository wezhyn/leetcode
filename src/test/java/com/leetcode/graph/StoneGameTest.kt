package com.leetcode.graph

import com.onePrimitiveArray
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.23.2020
 */
class StoneGameTest {

    @Test
    fun stoneGame() {
        assertTrue(StoneGame().stoneGame("3,3,10,5".onePrimitiveArray { it.toInt() }))
        assertTrue(StoneGame().stoneGame("5,3,4,5".onePrimitiveArray { it.toInt() }))
    }
}