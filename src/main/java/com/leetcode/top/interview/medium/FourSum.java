package com.leetcode.top.interview.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 来源：
 * https://leetcode.com/problems/4sum/discuss/308118/java-3ms-pruning-solution-which-beats-100-with-explanation
 * <p>
 * 虽然使用O(n^3),但尽量使得循环尽早结束是个好想法
 *
 * @author wezhyn
 * @since 04.11.2020
 */
public class FourSum {

    @Test
    public void test() {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2, 2, -5, 4, 2, 6, 3, 2, 1, -7, -2, -9, 10}, 5));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        int maxValue=nums[nums.length - 1];
        for (int i=0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i]==nums[i - 1]) {
                continue;
            } else if (nums[i] + 3*maxValue < target) {
//                nums[i]过小
                continue;
            } else if (4*nums[i] > target) {
//                nums[i]过大
                break;
            }
            for (int j=i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j]==nums[j - 1]) {
//                    ans=num[i],num[j],num[l],num[r],故而对于后续相同的num[j]要跳过
                    continue;
                } else if (nums[i] + nums[j] + 2*maxValue < target) {
                    continue;
                } else if (nums[i] + 3*nums[j] > target) {
                    break;
                }
                int l=j + 1, r=nums.length - 1;
                while (l < r) {
                    int ans=nums[l] + nums[r] + nums[j] + nums[i];
                    if (l > j + 1 && nums[l]==nums[l - 1]) {
                        l++;
                        continue;
                    }
                    if (ans==target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                    } else if (ans < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return result;
    }
}
