package com.leetcode.top.interview.medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wezhyn
 * @since 04.14.2020
 */
public class ContiguousArray {

    @Test
    public void test() {
        System.out.println(findMaxLength(new int[]{0, 0, 1, 1, 0}));
    }

    public int findMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? 1 : -1;
            if (map.containsKey(sum)) {
                int len = i - map.get(sum);
                ans = Math.max(len, ans);
            } else {
                map.put(sum, i);
            }
        }
        return ans;
    }
}
