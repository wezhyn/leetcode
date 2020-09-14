package com.fiveeight;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 08.31.2020
 */
public class TranslateStringTest {

    @Test
    public void translateNum() {
        assertEquals(1, new TranslateString().translateNum(82));
        assertEquals(1, new TranslateString().translateNum(30));
        assertEquals(1, new TranslateString().translateNum(26));
        assertEquals(1, new TranslateString().translateNum(0));
        assertEquals(5, new TranslateString().translateNum(12158));
        assertEquals(2, new TranslateString().translateNum(126));
    }
}