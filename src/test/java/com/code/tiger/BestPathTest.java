package com.code.tiger;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 08.16.2020
 */
public class BestPathTest {

    @Test
    public void uniquePaths() {
        assertEquals(7, new BestPath().uniquePaths(
                new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}
        ));
    }
}