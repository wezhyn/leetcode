package com.offer

import com.onePrimitiveArray
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.26.2020
 */
class FindMinimumInRotatedSortedArrayTest {

    @Test
    fun findMin() {
        assertEquals(0, FindMinimumInRotatedSortedArray().findMinSimple("2,2,2,0,1".onePrimitiveArray { it.toInt() }))
        assertEquals(1, FindMinimumInRotatedSortedArray().findMinSimple("1,3,5".onePrimitiveArray { it.toInt() }))
        assertEquals(1, FindMinimumInRotatedSortedArray().findMinSimple("4,5,7,1,2,3".onePrimitiveArray { it.toInt() }))
        assertEquals(1, FindMinimumInRotatedSortedArray().findMin("1,3,5".onePrimitiveArray { it.toInt() }))
        assertEquals(1, FindMinimumInRotatedSortedArray().findMin("4,5,7,1,2,3".onePrimitiveArray { it.toInt() }))
        assertEquals(0, FindMinimumInRotatedSortedArray().findMin("2,2,2,0,1".onePrimitiveArray { it.toInt() }))
    }
}