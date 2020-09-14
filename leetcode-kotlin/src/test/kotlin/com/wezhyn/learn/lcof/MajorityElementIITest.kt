package com.wezhyn.learn.lcof

import com.wezhyn.learn.intArray
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.02.2020
 */
class MajorityElementIITest {

    @Test
    fun majorityElement() {
        assertEquals(listOf(2, 1), MajorityElementII().majorityElement("1,2,2,3,2,1,1,3".intArray()))
        assertEquals(listOf(1, 2), MajorityElementII().majorityElement("1,1,1,3,3,2,2,2".intArray()))
        assertEquals(listOf(3), MajorityElementII().majorityElement("3,2,3".intArray()))
    }
}