package com.leetcode.top.interview.medium;

import org.junit.Test;

import java.util.*;

/**
 * @author wezhyn
 * @since 04.06.2020
 */
public class ThreesSum {

    @Test
    public void test() {
        System.out.println(threeSum(new int[]{3, 0, 3, 2, -4, 0, -3, 2, 2, 0, -1, -5}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums.length==0 || nums[0] > 0 || nums[nums.length - 1] < 0) {
            return Collections.emptyList();
        }
        Set<List<Integer>> result=new HashSet<>();
        for (int i=0; i < nums.length - 2; i++) {
            int ni=nums[i], k=nums.length - 1, j=i + 1;
            if (ni > 0) {
                break;
            }
            while (j < k) {
                int nk=nums[k], nj=nums[j], nl=ni + nj;
                if (nl > 0 || nk < 0 ) {
                    break;
                }
                int sum=nl + nk;
                if (sum > 0) {
//                        正数 k 过大
                    k--;
                } else if (sum < 0) {
//                        负数过大
                    j++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    k--;
                    j++;
                }
            }
        }
        return new ArrayList<>(result);
    }

}
