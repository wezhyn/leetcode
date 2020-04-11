package com.leetcode.top.interview.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wezhyn
 * @since 04.02.2020
 */
public class RomanToInteger {


    @Test
    public void convert() {
        Assert.assertEquals(1994, romanToInt("MCMXCIV"));
        Assert.assertEquals(9, romanToInt("IX"));
    }

    public int romanToInt(String s) {
//        preIndex指向-1，next指向第0个
        int pre=0, rev=0;
        for (int curIndex=0; curIndex < s.length(); curIndex++) {
            int cur=roman(s.charAt(curIndex));
            if (pre < cur) {
                rev=rev + cur - 2*pre;
            } else {
                rev+=cur;
            }
            pre=cur;
        }
        return rev;
    }


    private int roman(char c) {
        switch (c) {
            case 'I': {
                return 1;
            }
            case 'V': {
                return 5;
            }
            case 'X': {
                return 10;
            }
            case 'L': {
                return 50;
            }
            case 'C': {
                return 100;
            }
            case 'D': {
                return 500;
            }
            case 'M': {
                return 1000;
            }
            default: {
                return 0;
            }
        }
    }

}
