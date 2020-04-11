package com.leetcode.aprilchallenge;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author wezhyn
 * @since 04.02.2020
 */
public class HappyNumber {


    @Test
    public void happy() {
        Assert.assertTrue(isHappy(19));
        Assert.assertFalse(isHappy(37));
        Assert.assertTrue(isHappy(32));
    }

    public boolean isHappy(int n) {
        HashMap<Integer, Object> nums=new HashMap<>(16);
        final Object value=new Object();
        int rev=n;
        while (rev!=1) {
            int cur=0;
            while (rev!=0) {
                int pop=rev%10;
                cur=cur + pop*pop;
                rev/=10;
            }
            final Object absent=nums.putIfAbsent(cur, value);
            if (absent==null) {
                if (cur==1) {
                    return true;
                }
            } else {
                return false;
            }
            rev=cur;
        }
        return true;
    }
}
