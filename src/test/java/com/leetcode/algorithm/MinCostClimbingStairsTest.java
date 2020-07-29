package com.leetcode.algorithm;

import com.leetcode.dp.limited.MinCostClimbingStairs;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 07.24.2020
 */
public class MinCostClimbingStairsTest {

    @Test
    public void minCostClimbingStairs() {
        assertEquals(6, new MinCostClimbingStairs().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}