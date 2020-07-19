package com.offer

import org.junit.Assert.assertArrayEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.19.2020
 */
class SlidingWindowMaximumTest {

    @Test
    fun maxSlidingWindow() {
        assertArrayEquals(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7),
                SlidingWindowMaximum().maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 1))
        assertArrayEquals(intArrayOf(3, 3, -1, 5, 5, 6, 7),
                SlidingWindowMaximum().maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 2))
        assertArrayEquals(intArrayOf(5, 5, 6, 7),
                SlidingWindowMaximum().maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 5))
        assertArrayEquals(intArrayOf(3, 5, 5, 6, 7),
                SlidingWindowMaximum().maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 4))
        assertArrayEquals(intArrayOf(3, 3, 5, 5, 6, 7),
                SlidingWindowMaximum().maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3))
    }
}