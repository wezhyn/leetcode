package com.leetcode.sub

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 *
 * @author wezhyn
 * @since 08.18.2020
 */
class SubArraySumEqualsKTest {

    @Test
    fun subarraySum() {
        assertEquals(2, SubArraySumEqualsK().subarraySum(intArrayOf(1, 1, -1, 1), 0))
        assertEquals(3, SubArraySumEqualsK().subarraySum(intArrayOf(1, 1, 1, 1), 2))
    }
}