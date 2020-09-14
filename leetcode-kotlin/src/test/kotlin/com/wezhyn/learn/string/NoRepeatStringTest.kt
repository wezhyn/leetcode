package com.wezhyn.learn.string

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 *
 * @author wezhyn
 * @since 08.23.2020
 */
class NoRepeatStringTest {

    @Test
    fun lengthOfLongestSubstring() {
        assertEquals(4, NoRepeatString().lengthOfLongestSubstring("ababcd"))
        assertEquals(1, NoRepeatString().lengthOfLongestSubstring("a"))
        assertEquals(0, NoRepeatString().lengthOfLongestSubstring(""))
        assertEquals(3, NoRepeatString().lengthOfLongestSubstring("pwwkew"))
        assertEquals(3, NoRepeatString().lengthOfLongestSubstring("abcabcbd"))
        assertEquals(1, NoRepeatString().lengthOfLongestSubstring("bbbbb"))
        assertEquals(3, NoRepeatString().lengthOfLongestSubstring("abcabcbb"))
    }
}