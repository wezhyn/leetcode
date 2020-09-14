package com.wezhyn.learn.array;

/**
 * @author wezhyn
 * @since 08.29.2020
 */
public class RemoveDuplicateFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
//        l 指向当前最小不重复的元素
        int l = 0, r = 1;
        while (r < nums.length) {
            if (nums[r] == nums[l]) {
                r++;
            } else {
                nums[++l] = nums[r++];
            }
        }
        return l + 1;
    }

}
