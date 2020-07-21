package com.random

import org.junit.Assert.assertArrayEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.21.2020
 */
class RevealCardsIncreasingOrderTest {

    @Test
    fun deckRevealedIncreasing() {
        assertArrayEquals(
                intArrayOf(2, 13, 3, 11, 5, 17, 7), RevealCardsIncreasingOrder().deckRevealedIncreasing(
                intArrayOf(17, 13, 11, 2, 3, 5, 7)
        )
        )
    }
}