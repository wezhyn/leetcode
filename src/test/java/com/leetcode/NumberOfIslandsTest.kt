package com.leetcode

import org.junit.Test

/**
 * @author wezhyn
 * @since 06.19.2020
 */
class NumberOfIslandsTest {

    @Test
    fun numIslands() {
        NumberOfIslands().numIslands(arrayOf(
                charArrayOf('1', '1', '1'),
                charArrayOf('0', '1', '0'),
                charArrayOf('1', '1', '1')
        )).apply(System.out::println)
    }
}