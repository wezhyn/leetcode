package com.leetcode.top.interview.easy;

/**
 * @author wezhyn
 * @since 04.04.2020
 */
public class PlusOne {



    public int[] plusOne(int[] digits) {
        int m=digits.length - 1;
        int plus=0;
        while (m >= 0 && plus==0) {
            int cur=digits[m];
            plus=plusOne(cur);
            digits[m]=plus;
            m--;
        }
        if (digits[0]==0) {
            int[] n=new int[digits.length+1];
            n[0]=1;
            System.arraycopy(digits,0,n,1,digits.length);
            return n;
        }
        return digits;
    }

    private int plusOne(int x) {
        if (x==9) {
            return 0;
        } else {
            return x + 1;
        }
    }
}
