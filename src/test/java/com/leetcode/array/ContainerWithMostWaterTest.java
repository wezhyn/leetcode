package com.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wezhyn
 * @since 08.28.2020
 */
public class ContainerWithMostWaterTest {

    @Test
    public void maxArea() {
        Assert.assertEquals(49, new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));

    }
}