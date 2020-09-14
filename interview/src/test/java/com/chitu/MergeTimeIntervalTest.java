package com.chitu;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author wezhyn
 * @since 08.07.2020
 */
public class MergeTimeIntervalTest {

    @Test
    public void merge() {
        assertArrayEquals(new int[][]{{1, 6}},
                new MergeTimeInterval().merge(new int[][]{{1, 4}, {4, 6}}));
        assertArrayEquals(new int[][]{{1, 6}, {8, 10}, {15, 18}},
                new MergeTimeInterval().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
    }
}