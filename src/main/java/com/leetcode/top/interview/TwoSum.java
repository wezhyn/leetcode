package com.leetcode.top.interview;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author wezhyn
 * @since 03.09.2020
 */
public class TwoSum {

    public static void main(String[] args) {
        final TwoSum sum=new TwoSum();
        int[] test=new int[]{2, 7, 11, 12};
        final int[] ints=sum.twoSum(test, 9);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int[] result=null;
        for (int i=0; i < nums.length; i++) {
            int minus=target - nums[i];
            if (minus > 0) {
                if (map.containsKey(minus)) {
                    result=new int[2];
                    result[0]=minus;
                    result[1]=nums[i];
                    break;
                } else {
                    map.put(nums[i], minus);
                }
            }
        }
        return result;
    }
}
