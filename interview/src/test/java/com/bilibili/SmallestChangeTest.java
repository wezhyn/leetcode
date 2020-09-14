package com.bilibili;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 08.13.2020
 */
public class SmallestChangeTest {

    @Test
    public void getCoinCount() {
        assertEquals(17, new SmallestChange().GetCoinCount(200));
    }
}