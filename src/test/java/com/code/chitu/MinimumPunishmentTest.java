package com.code.chitu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 08.07.2020
 */
public class MinimumPunishmentTest {

    @Test
    public void minPath() {
        assertEquals(2, new MinimumPunishment().minPath(3,
                new int[][]{{1, 2, 1}, {2, 3, 3}, {1, 3, 2}}, 1, 3));
        assertEquals(3, new MinimumPunishment().minPath(3,
                new int[][]{{1, 2, 1}, {2, 3, 3}, {1, 3, 100}}, 1, 3));
    }
}