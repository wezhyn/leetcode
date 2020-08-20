package com.code.youzan;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 08.20.2020
 */
public class MaxNumTest {

    @Test
    public void maxSumDivFive() {
        assertEquals(20, new MaxNum().maxSumDivFive(new int[]{3, 6, 5, 1, 8}));
    }
}