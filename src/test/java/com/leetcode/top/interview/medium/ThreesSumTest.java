package com.leetcode.top.interview.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author wezhyn
 * @since 07.18.2020
 */
public class ThreesSumTest {

    @Test
    public void threeSum() {
        final ArrayList<List<Integer>> result = new ArrayList<>();
        Collections.addAll(result, Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1));
        assertEquals(result,
                new ThreesSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4})
        );
    }
}