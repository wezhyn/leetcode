package com.leetcode.top.interview.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wezhyn
 * @since 04.04.2020
 */
public class Sqrt {

    @Test
    public void test() {
        Assert.assertEquals(2,mySqrt(8));
    }
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }
}
