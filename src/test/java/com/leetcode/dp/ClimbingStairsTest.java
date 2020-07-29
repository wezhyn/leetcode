package com.leetcode.dp;

import com.leetcode.dp.limited.ClimbingStairs;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 07.24.2020
 */
public class ClimbingStairsTest {

    @Test
    public void climbStairsPro() {
        assertEquals(3, new ClimbingStairs().climbStairsPro(3));
        assertEquals(5, new ClimbingStairs().climbStairsPro(4));
    }
}