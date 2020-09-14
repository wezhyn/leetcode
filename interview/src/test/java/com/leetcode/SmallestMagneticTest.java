package com.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 08.16.2020
 */
public class SmallestMagneticTest {

    @Test
    public void maxDistance() {
        assertEquals(12, new SmallestMagnetic().maxDistance(new int[]{94, 95, 37, 30, 67, 7, 5, 44, 26, 55, 42, 28, 97, 19, 100, 74, 13, 88, 18}, 7));
        assertEquals(3, new SmallestMagnetic().maxDistance(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 4));
        assertEquals(999999999, new SmallestMagnetic().maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2));
        assertEquals(3, new SmallestMagnetic().maxDistance(new int[]{1, 2, 3, 4, 7}, 3));
    }
}