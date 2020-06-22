package com.leetcode

import com.leetcode.graph.RedundantConnection
import org.junit.Assert.assertArrayEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.19.2020
 */
class RedundantConnectionTest {

    @Test
    fun findRedundantConnection() {
        assertArrayEquals(intArrayOf(2, 3), RedundantConnection().findRedundantConnection(arrayOf(
                intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 3))))
        assertArrayEquals(intArrayOf(1, 4), RedundantConnection().findRedundantConnection(arrayOf(
                intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(1, 4), intArrayOf(1, 5)
        )))
    }
}