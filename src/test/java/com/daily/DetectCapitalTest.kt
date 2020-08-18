package com.daily

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 *
 * @author wezhyn
 * @since 08.18.2020
 */
class DetectCapitalTest {

    @Test
    fun detectCapitalUse() {
        assertTrue(DetectCapital().detectCapitalUse("a"))
        assertTrue(DetectCapital().detectCapitalUse("A"))
        assertFalse(DetectCapital().detectCapitalUse("usA"))
        assertTrue(DetectCapital().detectCapitalUse("usa"))
        assertFalse(DetectCapital().detectCapitalUse("Usa"))
        assertFalse(DetectCapital().detectCapitalUse("USa"))
    }
}