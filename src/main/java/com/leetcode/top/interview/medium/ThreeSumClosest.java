package com.leetcode.top.interview.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author wezhyn
 * @since 04.07.2020
 */
public class ThreeSumClosest {

    @Test
    public void test() {
        Assert.assertEquals(8,threeSumClosest(new int[]{1,2,3,4,5,6},8));
        Assert.assertEquals(2,threeSumClosest(new int[]{-1,2,1,-4},1));
        Assert.assertEquals(2,threeSumClosest(new int[]{-1,2,1,-4},2));
        Assert.assertEquals(-3,threeSumClosest(new int[]{-1,2,-4},2));
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest=Integer.MAX_VALUE;
        for (int i=0; i <= nums.length - 3; i++) {
            int l=i + 1, r=nums.length - 1, ni=nums[i];
            while (l < r) {
                int nl=nums[l], nr=nums[r];
                int sum=nl + nr + ni;
                int oc=sum - target;
                if (oc==0) {
                    return target;
                } else {
                    if (oc > 0) {
                        r--;
                    } else {
                        l++;
                    }
                    if (Math.abs(oc) < Math.abs(closest)) {
                        closest=oc;
                    }
                }
            }
        }
        return target + closest;
    }
}
