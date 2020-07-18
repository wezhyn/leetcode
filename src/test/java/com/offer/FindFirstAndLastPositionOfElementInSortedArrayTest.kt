package com.offer

import com.intArray
import org.junit.Assert.assertArrayEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.18.2020
 */
class FindFirstAndLastPositionOfElementInSortedArrayTest {

    @Test
    fun searchRange() {
        assertArrayEquals(intArrayOf(0, 6), FindFirstAndLastPositionOfElementInSortedArray()
                .searchRange(intArrayOf(5, 5, 5, 5, 5, 5, 5), 5))
        assertArrayEquals(intArrayOf(-1, -1), FindFirstAndLastPositionOfElementInSortedArray()
                .searchRange(intArrayOf(), 5))
        assertArrayEquals(intArrayOf(0, 1), FindFirstAndLastPositionOfElementInSortedArray()
                .searchRange("5,5".intArray(), 5))
        assertArrayEquals(intArrayOf(0, 0), FindFirstAndLastPositionOfElementInSortedArray()
                .searchRange("5".intArray(), 5))
        assertArrayEquals(intArrayOf(-1, -1), FindFirstAndLastPositionOfElementInSortedArray()
                .searchRange("5,7,7,8,8,10".intArray(), 6))
        assertArrayEquals(intArrayOf(3, 5), FindFirstAndLastPositionOfElementInSortedArray()
                .searchRange("5,7,7,8,8,8".intArray(), 8))
        assertArrayEquals(intArrayOf(3, 4), FindFirstAndLastPositionOfElementInSortedArray()
                .searchRange("5,7,7,8,8,10".intArray(), 8))
    }
}