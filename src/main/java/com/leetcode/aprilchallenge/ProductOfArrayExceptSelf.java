package com.leetcode.aprilchallenge;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wezhyn
 * @since 04.16.2020
 */
public class ProductOfArrayExceptSelf {

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{24, 12, 8, 6}, productExceptSelf(new int[]{1, 2, 3, 4}));
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] output = new int[length];
        output[0] = 1;
        for (int i = 1; i < length; i++) {
            output[i] = nums[i - 1] * output[i - 1];
        }
        int r = 1;
        for (int i = length - 1; i >= 0; i--) {
            output[i] = output[i] * r;
            r *= nums[i];
        }
        return output;
    }
}
