package com.zhongan;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 08.29.2020
 */
public class LongestRepeatNumTest {

    @Test
    public void longestRepeatingSubstring() {
        assertEquals(2, new LongestRepeatNum().longestRepeatingSubstring("abbadc"));
        assertEquals(2, new LongestRepeatNum().longestRepeatingSubstring("abb"));
        assertEquals(0, new LongestRepeatNum().longestRepeatingSubstring("abs"));
    }
}