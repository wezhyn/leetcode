package com.leetcode.aprilchallenge;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wezhyn
 * @since 04.19.2020
 */
public class SearchInRotatedSortedArray {

    @Test
    public void test() {
        Assert.assertEquals(3, search(new int[]{4, 5, 1, 2}, 2));
        Assert.assertEquals(0, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
        Assert.assertEquals(1, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
        Assert.assertEquals(5, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));
        Assert.assertEquals(2, search(new int[]{2, 3, 1}, 1));
        Assert.assertEquals(1, search(new int[]{2, 3, 1}, 3));
        Assert.assertEquals(-1, search(new int[]{}, 0));
    }

    public int search(int[] nums, int target) {
        if (nums.length < 1) return -1;
        int s = 0;
        int e = nums.length - 1;
        int m;

        while (s <= e) {
            m = (s + e) / 2;
            if (target == nums[m]) return m;

            if (nums[s] <= nums[m]) { /* Array is sorted from s to m */
                if (nums[m] > target && nums[s] <= target) // check if target is in sorted part
                    e = m - 1;
                else s = m + 1;
            } else { // Array is sorted from m to e
                if (nums[m] < target && nums[e] >= target) // check if target is in sorted part
                    s = m + 1;
                else e = m - 1;
            }
        }
        return -1;
    }

}
