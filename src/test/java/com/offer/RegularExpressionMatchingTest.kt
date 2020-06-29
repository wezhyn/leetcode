package com.offer

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.29.2020
 */
class RegularExpressionMatchingTest {

    @Test
    fun isMatch() {
        assertTrue(RegularExpressionMatching().isMatch("aabd", "aabd*"))
        assertTrue(RegularExpressionMatching().isMatch("a", "ab*"))
        assertTrue(RegularExpressionMatching().isMatch("a", "."))
        assertTrue(RegularExpressionMatching().isMatch("aab", "c*a*b*"))
        assertTrue(RegularExpressionMatching().isMatch("aabbc", "a*.*c"))
        assertTrue(RegularExpressionMatching().isMatch("abcdef", "a*b*c*d*e*."))
        assertTrue(RegularExpressionMatching().isMatch("aaaa", ".*a"))
        assertTrue(RegularExpressionMatching().isMatch("aaaa", "a*a"))
        assertFalse(RegularExpressionMatching().isMatch("aaaa", ".*b"))
        assertFalse(RegularExpressionMatching().isMatch("aaab", "a*c"))
        assertTrue(RegularExpressionMatching().isMatch("aaab", "a*b"))
        assertTrue(RegularExpressionMatching().isMatch("aaab", "aaab"))
    }
}