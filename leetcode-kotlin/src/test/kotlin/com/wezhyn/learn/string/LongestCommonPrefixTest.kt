package com.wezhyn.learn.string

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 *
 * @author wezhyn
 * @since 08.23.2020
 */
class LongestCommonPrefixTest {

    @Test
    fun longestCommonPrefix() {
        assertEquals("a", LongestCommonPrefix().longestCommonPrefix(arrayOf("a", "ab")))
        assertEquals("", LongestCommonPrefix().longestCommonPrefix(arrayOf("dog", "racecar", "car")))
        assertEquals("fl", LongestCommonPrefix().longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    }
}