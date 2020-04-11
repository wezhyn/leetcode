package com.leetcode.top.interview.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wezhyn
 * @since 04.05.2020
 */
public class IntegerToRoman {

    int[] nums=new int[]{1000,900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] values=new String[]{"M","CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


    @Test
    public void test() {
        Assert.assertEquals("MCMXCIV",intToRoman(1994));
        Assert.assertEquals("I",intToRoman(1));
        Assert.assertEquals("II",intToRoman(2));
        Assert.assertEquals("IV",intToRoman(4));
        Assert.assertEquals("LVIII",intToRoman(58));
        Assert.assertEquals("LIX",intToRoman(59));
    }

    public String intToRoman(int num) {
        StringBuilder sb=new StringBuilder();
        int numCp=num;
        for (int i=0; i < nums.length; i++) {
            int n=nums[i];
            int mod=numCp/n;
            if (mod!=0) {
                sb.append(romans(mod, values[i]));
            }
            numCp=numCp - mod*n;
        }
        return sb.toString();
    }

    public String romans(int count, String value) {
        StringBuilder sb=new StringBuilder();
        for (int i=0; i < count; i++) {
            sb.append(value);
        }
        return sb.toString();
    }


}
