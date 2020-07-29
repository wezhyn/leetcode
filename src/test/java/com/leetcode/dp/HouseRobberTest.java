package com.leetcode.dp;

import com.leetcode.dp.limited.HouseRobber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 07.24.2020
 */
public class HouseRobberTest {

    @Test
    public void rob() {
        assertEquals(4, new HouseRobber().rob(new int[]{1, 2, 3, 1}));
    }
}