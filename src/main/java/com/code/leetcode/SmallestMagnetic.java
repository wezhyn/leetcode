package com.code.leetcode;

import java.util.Arrays;

/**
 * 已知两个球如果分别位于x和y，那么它们之间的磁力为|x - y
 * <p>
 * 给你一个整数数组position和一个整数m，请你返回最大化的最小磁力。
 * <p>
 * 使用值二分的思想，推选出一个预测答案，并对预测答案进行调整
 *
 * @author wezhyn
 * @since 08.16.2020
 */
public class SmallestMagnetic {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
//        最小距离为1，最大距离为 首位/m-1
        int left = 1, right = (position[position.length - 1] - position[0]) / (m - 1);
        int result = left;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            switch (check(position, m, middle)) {
                case 0:
                case 1: {
//                    当前 middle 过小
                    left = middle + 1;
                    result = Math.max(middle, result);
                    break;
                }
                default: {
                    right = middle - 1;
                }
            }
        }
        return result;
    }

    // 0: 正好，1 超过m ,-1 小于m
    private int check(int[] position, int m, int x) {
        int result = 0;
        int target = 0;
        for (int j : position) {
            if (j >= target) {
                result++;
                target = j + x;
            }
        }
        return Integer.compare(result, m);
    }
}
