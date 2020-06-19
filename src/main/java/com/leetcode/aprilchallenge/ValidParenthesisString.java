package com.leetcode.aprilchallenge;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wezhyn
 * @since 04.16.2020
 */
public class ValidParenthesisString {

    @Test
    public void test() {
        Assert.assertFalse(checkValidString("()**((*"));
        Assert.assertTrue(checkValidString("(*))"));
        Assert.assertTrue(checkValidString("((*)"));
        Assert.assertTrue(checkValidString("()"));
        Assert.assertTrue(checkValidString("(*)"));
    }

    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(': {
                    low += 1;
                    high += 1;
                    break;
                }
                case '*': {
//                    0,1,-1
                    low -= 1;
                    high += 1;
                    break;
                }
                case ')': {
                    low -= 1;
                    high -= 1;
                }
            }
            if (high < 0) {
                return false;
            }
            low = Math.max(0, low);
        }
        return low == 0;
    }
}
