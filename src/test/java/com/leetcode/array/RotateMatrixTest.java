package com.leetcode.array;

import org.junit.Test;

/**
 * @author wezhyn
 * @since 08.29.2020
 */
public class RotateMatrixTest {

    @Test
    public void rotate() {
        new RotateMatrix().rotate(new int[][]{
                {5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}
        });
    }
}