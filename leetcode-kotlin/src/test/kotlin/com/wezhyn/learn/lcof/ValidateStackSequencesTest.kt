package com.wezhyn.learn.lcof

import com.wezhyn.learn.onePrimitiveArray
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.30.2020
 */
class ValidateStackSequencesTest {

    @Test
    fun validateStackSequences() {
        assertFalse(ValidateStackSequences().validateStackSequences(
                "1,2,3,4,5".onePrimitiveArray { it.toInt() }, "4,3,5,1,2".onePrimitiveArray { it.toInt() }
        ))
        assertTrue(ValidateStackSequences().validateStackSequences(
                "1,2,3,4,5".onePrimitiveArray { it.toInt() }, "4,5,3,2,1".onePrimitiveArray { it.toInt() }
        ))
    }
}