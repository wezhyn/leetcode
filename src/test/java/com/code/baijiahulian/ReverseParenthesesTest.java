package com.code.baijiahulian;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 08.07.2020
 */
public class ReverseParenthesesTest {

    @Test
    public void reverseParentheses() {
        assertEquals("iloveu", new ReverseParentheses().reverseParentheses("(u(love)i)"));
        assertEquals("dcba", new ReverseParentheses().reverseParentheses("(abcd)"));
    }
}