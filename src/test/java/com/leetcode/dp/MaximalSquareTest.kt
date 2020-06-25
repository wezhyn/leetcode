package com.leetcode.dp

import com.twoPrimitiveArray
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.25.2020
 */
class MaximalSquareTest {

    @Test
    fun maximalSquare() {
        assertEquals(9, MaximalSquare().maximalSquare("""
            [1 0 1 1 1], [1 0 1 1 1], [1 1 1 1 1], [1 0 0 1 0]""".twoPrimitiveArray(segmentation = " ") { it[0] }))
        assertEquals(4, MaximalSquare().maximalSquare("""
            [1 0 1 1 1], [1 0 1 1 1]""".twoPrimitiveArray(segmentation = " ") { it[0] }))
        assertEquals(0, MaximalSquare().maximalSquare("""
            []""".twoPrimitiveArray(segmentation = " ") { it[0] }))
        assertEquals(1, MaximalSquare().maximalSquare("""
            [1 0 1 1 1]""".twoPrimitiveArray(segmentation = " ") { it[0] }))
    }
}