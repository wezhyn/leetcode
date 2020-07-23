package com.leetcode.dp

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.23.2020
 */
class RemoveBoxesTest {
    @Test
    fun maxSegment() {
        val s = "abaaaabaa"
        assertEquals(0, RemoveBoxes().maxSegment(s, 0))
        assertEquals(5, RemoveBoxes().maxSegment(s, 2))
        assertEquals(8, RemoveBoxes().maxSegment(s, 7))
    }

    @Test
    fun removeBoxes() {
        assertEquals(3, RemoveBoxes().removeBoxes(intArrayOf(7, 8, 9)))
        assertEquals(9, RemoveBoxes().removeBoxes(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)))
        assertEquals(20, RemoveBoxes().removeBoxes(intArrayOf(10, 30, 2, 2, 2, 3, 2, 3)))
        assertEquals(41, RemoveBoxes().removeBoxes(intArrayOf(1, 3, 2, 2, 2, 3, 2, 3, 1, 4, 5, 1, 4, 3, 1)))
        assertEquals(23, RemoveBoxes().removeBoxes(intArrayOf(1, 3, 2, 2, 2, 3, 4, 3, 1)))
    }
}