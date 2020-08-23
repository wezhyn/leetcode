package com.leetcode.top.interview.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wezhyn
 * @since 08.23.2020
 */
public class LongestCommonPrefixTest {
    @Test
    public void test() {
        Assert.assertEquals("a", new LongestCommonPrefix().longestCommonPrefix(new String[]{"a", "ab"}));
        Assert.assertEquals("fl", new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        Assert.assertEquals("", new LongestCommonPrefix().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

}