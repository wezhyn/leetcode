package com.wezhyn.learn.lcof

import com.wezhyn.learn.onePrimitiveArray
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.26.2020
 */
class DuplicateNumberTest {

    @Test
    fun duplicateOne() {
        assertEquals(2, DuplicateNumber().duplicateOneNotModify("1,3,2,0,2,5,3".onePrimitiveArray { it.toInt() }))
    }
}