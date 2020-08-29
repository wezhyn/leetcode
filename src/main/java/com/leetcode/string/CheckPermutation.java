package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wezhyn
 * @since 08.29.2020
 */
public class CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, int[]> nums = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            final int[] cInts = nums.computeIfAbsent(c1, k -> new int[]{0});
            cInts[0]++;
            char c2 = s2.charAt(i);
            final int[] c2Ints = nums.computeIfAbsent(c2, k -> new int[]{0});
            c2Ints[0]--;
        }
        for (Map.Entry<Character, int[]> entry : nums.entrySet()) {
            if (entry.getValue()[0] != 0) {
                return false;
            }
        }
        return true;
    }
}
