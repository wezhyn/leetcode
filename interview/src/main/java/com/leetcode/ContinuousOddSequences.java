package com.leetcode;

/**
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false
 *
 * @author wezhyn
 * @since 08.16.2020
 */
public class ContinuousOddSequences {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; ) {
            boolean isBreak = false;
            for (int j = 0; j <= 2; j++) {
                int li = i + j;
                if ((arr[li] & 1) == 0) {
                    i = i + j + 1;
                    isBreak = true;
                    break;
                }
            }
            if (!isBreak) {
                return true;
            }
        }
        return false;
    }
}
