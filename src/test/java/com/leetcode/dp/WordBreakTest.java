package com.leetcode.dp;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * @author wezhyn
 * @since 07.25.2020
 */
public class WordBreakTest {

    @Test
    public void wordBreak() {
        assertTrue(new WordBreak().wordBreak("catsanddog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}