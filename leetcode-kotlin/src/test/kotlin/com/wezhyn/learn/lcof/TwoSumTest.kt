package com.wezhyn.learn.lcof

import com.wezhyn.learn.intArray
import org.junit.Assert.assertArrayEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.18.2020
 */
class TwoSumTest {

    @Test
    fun twoAscSum() {
        assertArrayEquals(intArrayOf(0, 2), TwoSum().twoAscSum("2, 7, 11, 15".intArray(), 13))
        assertArrayEquals(intArrayOf(0, 1), TwoSum().twoAscSum("2, 7, 11, 15".intArray(), 9))
    }

    @Test
    fun twoSum() {
        assertArrayEquals(intArrayOf(0, 2), TwoSum().twoSum("2, 7, 11, 15".intArray(), 13))
        assertArrayEquals(intArrayOf(0, 1), TwoSum().twoSum("2, 7, 11, 15".intArray(), 9))
    }
}