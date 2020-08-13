package com.code.bilibili;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author wezhyn
 * @since 08.13.2020
 */
public class TwentyFourTest {

    @Test
    public void game24Points() {
        assertTrue(new TwentyFour().Game24Points(new int[]{2, 4, 4, 6}));
        assertTrue(new TwentyFour().Game24Points(new int[]{2, 4, 4, 6}));
        assertTrue(new TwentyFour().Game24Points(new int[]{7, 2, 1, 10}));
    }
}