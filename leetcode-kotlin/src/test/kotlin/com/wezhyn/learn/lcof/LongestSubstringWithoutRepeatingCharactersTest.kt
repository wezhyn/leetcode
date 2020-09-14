package com.wezhyn.learn.lcof

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.13.2020
 */
class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    fun lengthOfLongestSubstring() {
        assertEquals(3, LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"))
        assertEquals(1, LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"))
        assertEquals(1, LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("aaaa"))
        assertEquals(0, LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(""))
        assertEquals(8, LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("absdf123dfabsdf123df"))
    }
}