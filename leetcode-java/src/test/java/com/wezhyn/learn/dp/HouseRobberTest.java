package com.wezhyn.learn.dp;

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