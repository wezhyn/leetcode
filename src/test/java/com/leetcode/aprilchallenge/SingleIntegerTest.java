package com.leetcode.aprilchallenge;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 07.18.2020
 */
public class SingleIntegerTest {

    @Test
    public void singleNumber() {
        assertEquals('c', new SingleInteger().singleNumber(new int[]{'a', 'b', 'b', 'c', 'a'}));
        assertEquals(4, new SingleInteger().singleNumber(new int[]{1, 2, 3, 2, 3, 1, 4}));
    }
}