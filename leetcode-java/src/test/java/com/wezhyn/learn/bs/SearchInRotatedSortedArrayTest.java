package com.wezhyn.learn.bs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 08.29.2020
 */
public class SearchInRotatedSortedArrayTest {

    @Test
    public void search() {
        assertEquals(0, new SearchInRotatedSortedArray().search(new int[]{3, 1, 2}, 3));
        assertEquals(4, new SearchInRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}