package com.leetcode.top.interview.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wezhyn
 * @since 04.09.2020
 */
public class BinaryWatch {
    /**
     * Map bits to time
     */
    static Map<Integer, Integer> bitsToTime = new HashMap<>();

    static {
        // hours
        bitsToTime.put(0, 1);
        bitsToTime.put(1, 2);
        bitsToTime.put(2, 4);
        bitsToTime.put(3, 8);

        // minutes
        bitsToTime.put(4, 1);
        bitsToTime.put(5, 2);
        bitsToTime.put(6, 4);
        bitsToTime.put(7, 8);
        bitsToTime.put(8, 16);
        bitsToTime.put(9, 32);
    }


}
