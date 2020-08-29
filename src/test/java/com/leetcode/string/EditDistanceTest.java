package com.leetcode.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 08.29.2020
 */
public class EditDistanceTest {

    @Test
    public void minDistance() {
        assertEquals(3, new EditDistance().minDistance("horse", "ros"));
    }
}