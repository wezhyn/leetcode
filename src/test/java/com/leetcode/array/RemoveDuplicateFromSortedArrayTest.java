package com.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wezhyn
 * @since 08.29.2020
 */
public class RemoveDuplicateFromSortedArrayTest {

    @Test
    public void removeDuplicates() {
        Assert.assertEquals(2, new RemoveDuplicateFromSortedArray().removeDuplicates(new int[]{1, 1, 2}));
        Assert.assertEquals(1, new RemoveDuplicateFromSortedArray().removeDuplicates(new int[]{1,}));
    }
}