package com.leetcode.top.interview.medium;


import java.util.*;

/**
 * 3数之和，a+b+c=0 可以看作 a+b=-c
 * <p>
 * 选择一个元素作为c，为了避免使用Hashmap引起的重复元素，使用@see {@link com.offer.TwoSum} 中的递增序列的双指针
 *
 * @author wezhyn
 * @since 04.06.2020
 */
public class ThreesSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0 || nums[0] > 0 || nums[nums.length - 1] < 0) {
            return Collections.emptyList();
        }
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int ni = nums[i], k = nums.length - 1, j = i + 1;
            if (ni > 0) {
                break;
            }
            while (j < k) {
                int nk = nums[k], nj = nums[j], nl = ni + nj;
                if (nl > 0 || nk < 0) {
                    break;
                }
                int sum = nl + nk;
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
