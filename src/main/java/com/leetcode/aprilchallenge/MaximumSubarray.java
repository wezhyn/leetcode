package com.leetcode.aprilchallenge;

import org.junit.Assert;
import org.junit.Test;

/**
 * f(x) 代表截至当前位的最大值
 * f(x) = f(x-1)>0? f(x-1)+arr[x]:arr[x]
 *
 * @author wezhyn
 * @since 04.03.2020
 */
public class MaximumSubarray {


    @Test
    public void test() {
        Assert.assertEquals(6, maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int dp1=nums[0];
        for (int i=1; i < nums.length; i++) {
            int dp2=dp1 < 0 ? nums[i] : nums[i] + dp1;
            dp1=dp2;
            if (dp2 > max) {
                max=dp2;
            }
        }
        return max;
    }
}
