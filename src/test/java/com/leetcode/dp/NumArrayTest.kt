package com.leetcode.dp

import com.onePrimitiveArray
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.23.2020
 */
class NumArrayTest {

    @Test
    fun sumRange() {
        val numArray = NumArray("-2, 0, 3, -5, 2, -1".onePrimitiveArray { it.toInt() })
        assertEquals(1, numArray.sumRange(0, 2))
        assertEquals(-1, numArray.sumRange(2, 5))
        assertEquals(-3, numArray.sumRange(0, 5))
        val numArray1 = NumArray("-2".onePrimitiveArray { it.toInt() })
        assertEquals(-2, numArray1.sumRange(0, 0))
    }
}