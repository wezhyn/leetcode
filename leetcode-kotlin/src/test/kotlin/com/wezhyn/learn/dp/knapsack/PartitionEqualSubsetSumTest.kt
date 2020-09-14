package com.wezhyn.learn.dp.knapsack

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 *
 * @author wezhyn
 * @since 07.31.2020
 */
class PartitionEqualSubsetSumTest {

    @Test
    fun canPartition() {
        assertTrue(PartitionEqualSubsetSum().best(intArrayOf(10, 50, 110, 50)))
        assertFalse(PartitionEqualSubsetSum().best(intArrayOf(1, 2, 3, 5)))
    }
}