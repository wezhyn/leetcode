package com.wezhyn.learn.array;

/**
 * @author wezhyn
 * @since 08.29.2020
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int preMax = Integer.MIN_VALUE;
        int max = 0, cur = 0;
        for (int num : nums) {
            if (num > preMax) {
                cur++;
            } else {
                cur = 1;
            }
            max = Math.max(max, cur);
            preMax = num;
        }
        return max;
    }
}
