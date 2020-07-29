package com.leetcode.dp.limited

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.24.2020
 */
class MinimumSwapsToMakeSequencesIncreasingTest {

    @Test
    fun minSwap() {
        assertEquals(2, MinimumSwapsToMakeSequencesIncreasing()
                .minSwap(intArrayOf(3, 5, 6, 9, 14, 15, 15, 18, 17, 20), intArrayOf(3, 4, 5, 8, 10, 14, 17, 16, 19, 19)))
        assertEquals(1, MinimumSwapsToMakeSequencesIncreasing()
                .minSwap(intArrayOf(0, 3, 5, 8, 9), intArrayOf(2, 1, 4, 6, 9)))
        assertEquals(1, MinimumSwapsToMakeSequencesIncreasing()
                .minSwap(intArrayOf(1, 3, 5, 4), intArrayOf(1, 2, 3, 7)))
        assertEquals(1, MinimumSwapsToMakeSequencesIncreasing()
                .minSwap(intArrayOf(7, 2, 3, 4), intArrayOf(1, 8, 9, 10)))
        assertEquals(1, MinimumSwapsToMakeSequencesIncreasing()
                .minSwap(intArrayOf(1, 3, 5, 4), intArrayOf(1, 2, 3, 7)))
    }
}