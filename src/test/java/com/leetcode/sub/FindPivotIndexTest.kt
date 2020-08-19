package com.leetcode.sub

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 *
 * @author wezhyn
 * @since 08.18.2020
 */
class FindPivotIndexTest {

    @Test
    fun pivotIndex() {
        assertEquals(2, FindPivotIndex().pivotIndex(intArrayOf(1, 2, 3, 3)))
        assertEquals(-1, FindPivotIndex().pivotIndex(intArrayOf(1, 2, 3)))
        assertEquals(3, FindPivotIndex().pivotIndex(intArrayOf(1, 7, 3, 6, 5, 6)))
    }
}