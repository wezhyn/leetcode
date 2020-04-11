package com.leetcode.top.interview.easy;

/**
 * 感觉写了驼si
 * @author wezhyn
 * @since 03.31.2020
 */
public class StringToInteger {

    public static void main(String[] args) {
        System.out.println(new StringToInteger().myAtoi(" 0-2"));
    }

    public int myAtoi(String str) {
        int result=0;
        long rev=0;
        boolean isEnd=false;
        int strLength=str.length();
        for (int i=0; i < strLength; i++) {
            char c=str.charAt(i);
            if (c==' ') {
                if (isEnd) {
                    break;
                }
            } else if (c=='-') {
                if (!isEnd) {
                    result=-1;
                    isEnd=true;
                } else {
                    break;
                }
            } else if (c=='+') {
                if (!isEnd) {
                    result=1;
                    isEnd=true;
                } else {
                    break;
                }
            } else if (c >= '0' && c <= '9' && rev < Integer.MAX_VALUE) {
                isEnd=true;
                rev=rev*10 + (c - 48);
            } else {
                break;
            }
        }
        result=result==0 ? 1 : result;
        rev=result*rev;
        if (rev > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (rev < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) rev;
        }
    }
}
