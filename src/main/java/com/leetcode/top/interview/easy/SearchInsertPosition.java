package com.leetcode.top.interview.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wezhyn
 * @since 04.03.2020
 */
public class SearchInsertPosition {

    @Test
    public void test() {
        Assert.assertEquals(4, searchInsert(new int[]{1, 3, 5, 6}, 7));
        Assert.assertEquals(2, searchInsert(new int[]{1, 3, 5, 6}, 5));
        Assert.assertEquals(1, searchInsert(new int[]{1, 3, 5, 6}, 2));
        Assert.assertEquals(0, searchInsert(new int[]{1, 2, 4, 5, 6}, 0));
        Assert.assertEquals(1, searchInsert(new int[]{1}, 2));
    }

    public int searchInsert(int[] nums, int target) {
        int low=0;
        int high=nums.length - 1;
//        [low,high]
        while (low <= high) {
            int middle=(low + high)/2;
            if (nums[middle] > target) {
                high=middle - 1;
            } else if (nums[middle]==target) {
                return middle;
            } else {
                low=middle + 1;
            }
        }
        return low;
    }
}
