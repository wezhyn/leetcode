package com.wezhyn.learn.bs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 08.27.2020
 */
public class MedianOfTwoSortedArraysTest {

    @Test
    public void findMedianSortedArrays() {
        assertEquals(100000.5, new MedianOfTwoSortedArrays().findMedianSortedArrays(
                new int[]{100000}, new int[]{100001}
        ), 0.00001);
        assertEquals(2.5, new MedianOfTwoSortedArrays().findMedianSortedArrays(
                new int[]{1, 2}, new int[]{3, 4}
        ), 0.00001);
        assertEquals(2.0, new MedianOfTwoSortedArrays().findMedianSortedArrays(
                new int[]{1, 3}, new int[]{2}
        ), 0.00001);
    }
}