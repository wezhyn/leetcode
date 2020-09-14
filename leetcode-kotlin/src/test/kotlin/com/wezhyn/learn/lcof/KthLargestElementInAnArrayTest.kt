package com.wezhyn.learn.lcof

import com.wezhyn.learn.intArray
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.03.2020
 */
class KthLargestElementInAnArrayTest {

    @Test
    fun findKthLargest() {
        assertEquals(1, KthLargestElementInAnArray().findKthLargest("1".intArray(), 4))
        assertEquals(4, KthLargestElementInAnArray().findKthLargest("3,2,3,1,2,4,5,5,6".intArray(), 4))
        assertEquals(5, KthLargestElementInAnArray().findKthLargest("3,2,1,5,6,4".intArray(), 2))
    }
}