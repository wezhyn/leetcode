package com.leetcode.aprilchallenge;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

/**
 * @author wezhyn
 * @since 04.10.2020
 */
public class BackspaceStringCompare {
    @Test
    public void test() {
        Assert.assertTrue(backspaceCompare("ab##", "c#d#"));
        Assert.assertTrue(backspaceCompare("ab#c", "ad#c"));
        Assert.assertFalse(backspaceCompare("a#c","b"));
        Assert.assertTrue(backspaceCompare("","#"));
    }

    public boolean backspaceCompare(String S, String T) {
        return Objects.equals(clean(S), clean(T));
    }

    private String clean(String s) {
        char[] chars=s.toCharArray();
        int fast=0, slow=0;
        while (fast < s.length()) {
            if (chars[fast]=='#') {
                slow=slowDecrease(slow);
            } else {
                chars[slow++]=chars[fast];
            }
            fast++;
        }
        return new String(chars, 0, slow);
    }

    private int slowDecrease(int slow) {
        slow--;
        return Math.max(slow, 0);
    }
}
