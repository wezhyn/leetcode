package com.leetcode.top.interview.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wezhyn
 * @since 04.03.2020
 */
public class RemoveElement {


    @Test
    public void test() {
        Assert.assertEquals(2, removeElement(new int[]{3, 2, 2, 3}, 3));
    }

    public int removeElement(int[] nums, int val) {
        int removalIndex=0;
        for (int i=0; i < nums.length; i++) {
            if (nums[i]!=val) {
                nums[removalIndex++]=nums[i];
            }
        }
        return removalIndex;
    }
}
