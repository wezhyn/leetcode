package com.leetcode.aprilchallenge;

import org.junit.Test;

/**
 * 不得不说，O(n)的时间复杂度，O(1)的空间复杂度，真是难顶，看见异或后，。。。无与伦比的惊叹
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

    @Test
    public void xor() {
        System.out.println('a'^'b'^'b'^'c'^'a');
        System.out.println(1^2^3^2^3^1^4);
        System.out.println(1^2^4);
    }

    @Test
    public void versus() {
        System.out.println(2&7&2);
    }
}
