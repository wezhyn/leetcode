package com.leetcode.aprilchallenge;


/**
 * <p> 异或：两个位相同时为 0，相异为 1
 * 0 ^ 0 = 0
 * 1 ^ 1 = 0
 * 0 ^ 1 = 1
 * 1 ^ 0 = 1
 * 支持交互定律
 * 与：两个位都为 1 时，结果才为 1
 * 或：两个位都是 0 时，结果才为 0
 *
 * @author wezhyn
 * @since 04.01.2020
 */
public class SingleInteger {


    public int singleNumber(int[] nums) {
        int i=0;
        for (int num : nums) {
            i^=num;
        }
        return i;
    }
}
