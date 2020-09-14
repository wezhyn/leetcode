package com.youzan;

/**
 * @author wezhyn
 * @since 08.20.2020
 */
public class MaxNum {
    private int maxNum = 0;

    public int maxSumDivFive(int[] nums) {
        maxNum = 0;
        maxNum(nums, 0, 0);
        return maxNum;
    }

    private void maxNum(int[] nums, int i, int result) {
        if (i == nums.length) {
            if (result % 5 == 0) {
                maxNum = Math.max(maxNum, result);
            }
            return;
        }
        maxNum(nums, i + 1, result + nums[i]);
        maxNum(nums, i + 1, result);
    }
}
