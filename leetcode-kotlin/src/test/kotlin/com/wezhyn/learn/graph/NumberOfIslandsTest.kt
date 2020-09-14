package com.wezhyn.learn.graph

import org.junit.Test
import kotlin.test.assertEquals

/**
 * @author wezhyn
 * @since 06.19.2020
 */
class NumberOfIslandsTest {

    @Test
    fun numIslands() {
        assertEquals(1, NumberOfIslands().numIslands(arrayOf(
                charArrayOf('1', '1', '1'),
                charArrayOf('0', '1', '0'),
                charArrayOf('1', '1', '1')
        )))
    }
}