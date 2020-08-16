package com.code.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author wezhyn
 * @since 08.16.2020
 */
public class ContinuousOddSequencesTest {

    @Test
    public void threeConsecutiveOdds() {
        assertTrue(new ContinuousOddSequences().threeConsecutiveOdds(new int[]{3, 3, 5}));
        assertFalse(new ContinuousOddSequences().threeConsecutiveOdds(new int[]{}));
        assertFalse(new ContinuousOddSequences().threeConsecutiveOdds(new int[]{1, 2}));
        assertFalse(new ContinuousOddSequences().threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 6, 7, 23, 12}));
        assertTrue(new ContinuousOddSequences().threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}));
    }
}