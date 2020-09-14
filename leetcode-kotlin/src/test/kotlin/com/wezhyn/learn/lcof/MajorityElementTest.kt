package com.wezhyn.learn.lcof

import com.wezhyn.learn.intArray
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.02.2020
 */
class MajorityElementTest {

    @Test
    fun majorityElement() {
        assertEquals(3, MajorityElement().majorityElement("""3,2,3""".intArray()))
        assertEquals(4, MajorityElement().majorityElement("4,5,4".intArray()))
        assertEquals(2, MajorityElement().majorityElement("2,2,1,1,1,2,2".intArray()))
    }
}