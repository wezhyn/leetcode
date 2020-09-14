package com.wezhyn.learn.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 08.27.2020
 */
public class LongestPalindromicSubstringTest {

    @Test
    public void longestPalindrome() {

        assertEquals("b", new LongestPalindromicSubstring().longestPalindrome("b"));
        assertEquals("bab", new LongestPalindromicSubstring().longestPalindrome("babad"));
    }
}