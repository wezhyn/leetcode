package com.leetcode.top.interview.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wezhyn
 * @since 04.03.2020
 */
public class ImplementStr {

    @Test
    public void test() {
        Assert.assertEquals(1, strStr("mississippi", "issi"));
        Assert.assertEquals(2, strStr("hello", "ll"));
        Assert.assertEquals(-1, strStr("aaaaa", "bba"));
        Assert.assertEquals(0, strStr("Hello", ""));
        Assert.assertEquals(-1, strStr("he", "hello"));
        Assert.assertEquals(0, strStr("aa", "aa"));
        Assert.assertEquals(0, strStr("aa", "a"));
    }

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int j=0;
        for (int i=0; i < haystack.length(); i++) {
            boolean e=haystack.charAt(i)==needle.charAt(j);
            if (e && (++j)==needle.length()) {
                return i - j + 1;
            } else if (!e) {
                i=i - j;
                j=0;
            }
        }
        return -1;
    }
}
