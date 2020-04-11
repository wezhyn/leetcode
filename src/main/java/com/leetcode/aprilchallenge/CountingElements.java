package com.leetcode.aprilchallenge;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * @author wezhyn
 * @since 04.07.2020
 */
public class CountingElements {


    @Test
    public void test() {
        Assert.assertEquals(2, countElements(new int[]{1, 1, 2, 2}));
    }

    public int countElements(int[] arr) {
        HashSet<Integer> cache=new HashSet<>(arr.length);
        for (int i : arr) {
            cache.add(i);
        }
        int count=0;

        for (int i : arr) {
            if (cache.contains(i + 1)) {
                count++;
            }
        }
        return count;
    }
}
