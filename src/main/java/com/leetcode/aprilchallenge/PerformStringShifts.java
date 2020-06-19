package com.leetcode.aprilchallenge;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wezhyn
 * @since 04.15.2020
 */
public class PerformStringShifts {

    @Test
    public void test() {
        Assert.assertEquals("qpifxqgwki", stringShift("xqgwkiqpif", new int[][]{
                {1, 4}, {0, 7}, {0, 8}, {0, 7}, {0, 6}, {1, 3}, {0, 1}, {1, 7}, {0, 5}, {0, 6}
        }));
        Assert.assertEquals("a", stringShift("a", new int[][]{{0, 1}, {1, 3}}));
        Assert.assertEquals("cab", stringShift("abc", new int[][]{{0, 1}, {1, 2}}));

    }

    public String stringShift(String s, int[][] shift) {
        int sum = 0;
        for (int[] ints : shift) {
            sum += ints[0] == 1 ? ints[1] : -ints[1];
        }
        sum = sum % s.length();
        if (sum > 0) {
            return s.substring(s.length() - sum) + s.substring(0, s.length() - sum);
        } else if (sum == 0) {
            return s;
        } else {
            sum = -sum;
            return s.substring(sum) + s.substring(0, sum);
        }
    }
}
