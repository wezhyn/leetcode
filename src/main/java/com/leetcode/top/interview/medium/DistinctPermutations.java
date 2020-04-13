package com.leetcode.top.interview.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 互斥排列
 * 1，2，3->
 * 2，3，1
 * 3，1，2
 *
 * @author wezhyn
 * @see Permutations
 * @since 04.13.2020
 */
public class DistinctPermutations {

    @Test
    public void test() {
        System.out.println(permute(new int[]{1, 2, 3, 4}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        if (nums.length==0) {
            ans.add(new ArrayList<>());
            return ans;
        }
        backtracking(nums, nums.clone(), ans, 0, nums.length - 1);
        return ans;
    }

    public void backtracking(int[] prepareNums, int[] originNums, List<List<Integer>> ans, int l, int r) {
        for (int i=l; i <= r; i++) {
            if (originNums[l]==prepareNums[i]) {
                continue;
            }
            if (l==r) {
                ans.add(Arrays.stream(prepareNums).boxed().collect(Collectors.toList()));
                return;
            }
            swap(prepareNums, l, i);
            backtracking(prepareNums, originNums, ans, l + 1, r);
            swap(prepareNums, l, i);
        }
    }

    public void swap(int[] nums, int l, int r) {
        int c=nums[l];
        nums[l]=nums[r];
        nums[r]=c;
    }
}
