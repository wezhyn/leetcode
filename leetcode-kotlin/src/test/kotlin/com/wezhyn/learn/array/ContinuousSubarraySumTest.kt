package com.wezhyn.learn.array

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 *
 * @author wezhyn
 * @since 08.18.2020
 */
class ContinuousSubarraySumTest {

    @Test
    fun checkSubarraySum() {
        assertTrue(ContinuousSubarraySum().checkSubarraySum(intArrayOf(0, 0, 0, 0), 2))
        assertFalse(ContinuousSubarraySum().checkSubarraySum(intArrayOf(1, 0), 2))
        assertFalse(ContinuousSubarraySum().checkSubarraySum(intArrayOf(0, 1, 1), 0))
        assertFalse(ContinuousSubarraySum().checkSubarraySum(intArrayOf(0, 1, 0), 0))
        assertTrue(ContinuousSubarraySum().checkSubarraySum(intArrayOf(0, 0), 0))
        assertFalse(ContinuousSubarraySum().checkSubarraySum(intArrayOf(0), 0))
        assertTrue(ContinuousSubarraySum().checkSubarraySum(intArrayOf(1, 0, 0), 0))
        assertTrue(ContinuousSubarraySum().checkSubarraySum(intArrayOf(1, 0, 0, 1), 0))
    }
}