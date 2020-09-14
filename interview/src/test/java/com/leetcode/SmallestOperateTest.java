package com.leetcode;

import org.junit.Test;

/**
 * @author wezhyn
 * @since 08.16.2020
 */
public class SmallestOperateTest {

    @Test
    public void minOperations() {
        for (int i = 1; i < 10; i++) {
            System.out.println(new SmallestOperate().minOperations(i));
        }
    }
}