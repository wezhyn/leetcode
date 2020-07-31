package com.leetcode.dp

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 *
 * @author wezhyn
 * @since 07.31.2020
 */
class CoinChangeTest {

    @Test
    fun coinChange() {
        assertEquals(-1, CoinChange().coinChange(intArrayOf(2), 3))
        assertEquals(3, CoinChange().coinChange(intArrayOf(1, 2, 5), 11))
    }
}