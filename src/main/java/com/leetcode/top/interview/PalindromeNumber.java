package com.leetcode.top.interview;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wezhyn
 * @since 04.01.2020
 */
public class PalindromeNumber {

    @Test
    public void isPalindromeTest() {
        Assert.assertFalse(isPalindrome(-1));

        Assert.assertFalse(isPalindrome(-121));
        Assert.assertTrue(isPalindrome(121));
        Assert.assertFalse(isPalindrome(10));
    }
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int xc=x;
        long rev=0;
        for (int i=0; i < 11 && xc!=0; i++) {
            int pop=xc%10;
            rev=rev*10 + pop;
            xc/=10;
        }
        return rev==x;
    }
}
