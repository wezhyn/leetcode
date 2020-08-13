package com.code.bilibili;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author wezhyn
 * @since 08.13.2020
 */
public class BracketMatchingTest {

    @Test
    public void isValidExp() {
        assertTrue(new BracketMatching().IsValidExp("{[]}"));
        assertFalse(new BracketMatching().IsValidExp("([)]"));
        assertFalse(new BracketMatching().IsValidExp("([]"));
        assertTrue(new BracketMatching().IsValidExp(""));
    }
}