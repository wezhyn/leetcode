package com.wezhyn.learn.dp.knapsack

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 *
 * @author wezhyn
 * @since 07.31.2020
 */
class CoinChange2Test {

    @Test
    fun change() {
        assertEquals(1, CoinChange2().change(3, intArrayOf(3)))
        assertEquals(0, CoinChange2().change(3, intArrayOf(4)))
        assertEquals(0, CoinChange2().change(3, intArrayOf(2)))
        assertEquals(4, CoinChange2().change(5, intArrayOf(1, 2, 5)))
    }
}