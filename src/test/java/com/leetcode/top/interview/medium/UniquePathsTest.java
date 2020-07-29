package com.leetcode.top.interview.medium;

import com.leetcode.dp.limited.UniquePaths;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 07.24.2020
 */
public class UniquePathsTest {

    @Test
    public void uniquePaths() {
        assertEquals(3, new UniquePaths().uniquePaths(3, 2));
        assertEquals(28, new UniquePaths().uniquePaths(7, 3));
        assertEquals(2000000000, new UniquePaths().uniquePaths(100, 100));
    }

}