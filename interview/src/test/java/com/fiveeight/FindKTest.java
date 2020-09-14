package com.fiveeight;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 08.31.2020
 */
public class FindKTest {

    @Test
    public void question() {
        assertEquals(476, new FindK().question(100, 200));
    }
}