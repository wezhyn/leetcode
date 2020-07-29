package com.leetcode.dp

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.28.2020
 */
class EditDistanceTest {

    @Test
    fun minDistance() {
        assertEquals(2, EditDistance().minDistance("eah", "pea"))
        assertEquals(2, EditDistance().minDistance("teacher", "tepache"))
        assertEquals(2, EditDistance().minDistance("sea", "eat"))
        assertEquals(1, EditDistance().minDistance("sea", "ea"))
        assertEquals(1, EditDistance().minDistance("ab", "b"))
        assertEquals(1, EditDistance().minDistance("ab", "a"))
        assertEquals(2, EditDistance().minDistance("ab", ""))
        assertEquals(5, EditDistance().minDistance("intention", "execution"))
        assertEquals(3, EditDistance().minDistance("horse", "ros"))
    }
}