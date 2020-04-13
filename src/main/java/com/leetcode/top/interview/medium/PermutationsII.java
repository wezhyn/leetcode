package com.leetcode.top.interview.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wezhyn
 * @since 04.13.2020
 */
public class PermutationsII {
    @Test
    public void test() {
        final List<List<Integer>> result=permuteUnique(new int[]{1, 1, 2});
        System.out.println(result);
        Set<List<Integer>> r=new HashSet<>(result);
        Assert.assertEquals(r.size(), result.size());
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if (nums.length==0) {
            res.add(new ArrayList<>());
            return res;
        }
        backtracking(nums.clone(), 0, nums.length - 1, res);
        return res;
    }

    public void backtracking(int[] nums, int l, int r, List<List<Integer>> ans) {
        HashSet<Integer> visited=new HashSet<>();
        for (int i=l; i <= r; i++) {
            int v=nums[i];
            if (visited.contains(v)) {
                continue;
            } else {
                visited.add(v);
            }
            if (l==r) {
                ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                return;
            }
            swap(nums, l, i);
            backtracking(nums, l + 1, r, ans);
            swap(nums, l, i);
        }
    }

    public void swap(int[] nums, int l, int r) {
        int c=nums[l];
        nums[l]=nums[r];
        nums[r]=c;
    }
}
