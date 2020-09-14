package com.leetcode;

/**
 * 递增数组 arr[i] = (2 * i) + 1
 *
 * @author wezhyn
 * @since 08.16.2020
 */
public class SmallestOperate {
    public int minOperations(int n) {
        if ((n & 1) == 0) {
            return (int) (Math.pow(n, 2) / 4);
        } else {
            return (n - 1) * (n + 1) / 4;
        }


    }
}
