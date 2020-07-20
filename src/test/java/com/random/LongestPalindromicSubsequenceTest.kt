package com.random

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.20.2020
 */
class LongestPalindromicSubsequenceTest {

    @Test
    fun longestPalindromeSubseq() {
        assertEquals(1, LongestPalindromicSubsequence().longestPalindromeSubseq("ba"))
        assertEquals(1, LongestPalindromicSubsequence().longestPalindromeSubseq("bac"))
        assertEquals(3, LongestPalindromicSubsequence().longestPalindromeSubseq("bab"))
        assertEquals(2, LongestPalindromicSubsequence().longestPalindromeSubseq("bb"))
        assertEquals(1, LongestPalindromicSubsequence().longestPalindromeSubseq("b"))
        assertEquals(4, LongestPalindromicSubsequence().longestPalindromeSubseq("bbbab"))
    }
}