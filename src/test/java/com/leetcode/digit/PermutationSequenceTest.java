package com.leetcode.digit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 09.05.2020
 */
public class PermutationSequenceTest {

    @Test
    public void getPermutation() {
        assertEquals("1324", new PermutationSequence().getPermutation(4, 3));
        assertEquals("132", new PermutationSequence().getPermutation(3, 2));
        assertEquals("2314", new PermutationSequence().getPermutation(4, 9));
        assertEquals("213", new PermutationSequence().getPermutation(3, 3));
    }
}