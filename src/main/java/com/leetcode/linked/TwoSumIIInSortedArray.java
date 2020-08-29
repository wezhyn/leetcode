package com.leetcode.linked;

/**
 * @author wezhyn
 * @since 08.29.2020
 */
public class TwoSumIIInSortedArray {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int lNum = numbers[l], rNum = numbers[r], sum = lNum + rNum;
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }
        return new int[0];
    }
}
