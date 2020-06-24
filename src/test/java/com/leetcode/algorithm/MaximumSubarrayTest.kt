package com.leetcode.algorithm

import com.leetcode.dp.MaximumSubarray
import com.onePrimitiveArray
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.24.2020
 */
class MaximumSubarrayTest {

    @Test
    fun maxSubArray() {
        assertEquals(0, MaximumSubarray().maxSubArray(IntArray(0)))
        assertEquals(6, MaximumSubarray().maxSubArray("-2,1,-3,4,-1,2,1,-5,4".onePrimitiveArray { it.toInt() }))
    }
}