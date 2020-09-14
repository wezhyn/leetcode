package com.wezhyn.learn.lcof

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.29.2020
 */
class ValidNumberTest {

    @Test
    fun isNumber() {
        assertFalse(ValidNumber().isNumber("4e+"))
        assertFalse(ValidNumber().isNumber("6+1"))
        assertTrue(ValidNumber().isNumber("-9e+3"))
        assertTrue(ValidNumber().isNumber("-9e-3"))
        assertTrue(ValidNumber().isNumber("-90e3"))
        assertTrue(ValidNumber().isNumber("2e10"))
        assertFalse(ValidNumber().isNumber("1 a"))
        assertFalse(ValidNumber().isNumber("abc"))
        assertTrue(ValidNumber().isNumber("0.1"))
        assertTrue(ValidNumber().isNumber("0"))
        assertTrue(ValidNumber().isNumber("10"))
    }
}