package com.code.chitu;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author wezhyn
 * @since 08.07.2020
 */
public class AbbreviationCheckTest {

    @Test
    public void valid() {
        assertFalse(new AbbreviationCheck().valid("word", "3e"));
        assertTrue(new AbbreviationCheck().valid("word", "3d"));
        assertTrue(new AbbreviationCheck().valid("word", "4"));
        assertFalse(new AbbreviationCheck().valid("apple", "a2e"));
        assertTrue(new AbbreviationCheck().valid("internationalization", "i12iz4n"));
    }
}