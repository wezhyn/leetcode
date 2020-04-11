package com.leetcode.top.interview.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wezhyn
 * @since 04.03.2020
 */
public class RemoveDuplicatesFromSortedArray {

    @Test
    public void test() {
        Assert.assertEquals(2, removeDuplicates(new int[]{1, 1, 2}));
        Assert.assertEquals(1, removeDuplicates(new int[]{1,}));
    }

    public int removeDuplicates(int[] nums) {
//        执行下一个要被替换的位置
        int next=nums.length > 0 ? 1 : 0;
        for (int i=1; i < nums.length; i++) {
            int pre=nums[i - 1];
            int cur=nums[i];
            if (cur!=pre) {
                nums[next++]=nums[i];
            }
        }
        return next;
    }

}
