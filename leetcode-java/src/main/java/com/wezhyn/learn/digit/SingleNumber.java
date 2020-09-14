package com.wezhyn.learn.digit;

/**
 * @author wezhyn
 * @since 09.14.2020
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int i = 0;
        for (int num : nums) {
            i ^= num;
        }
        return i;
    }
}
