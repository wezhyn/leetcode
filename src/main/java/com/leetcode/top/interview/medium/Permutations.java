package com.leetcode.top.interview.medium;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 全排列
 * 1，2，3->
 * 1，2，3，
 * 1，3，2，
 * 2，1，3，
 * 2，3，1
 * 3，1，2
 * 3，2，1
 *
 * @author wezhyn
 * @see DistinctPermutations
 * @since 04.13.2020
 */
public class Permutations {


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
        Queue<Integer> prepareNums=new LinkedList<>();
        for (int num : nums) {
            prepareNums.offer(num);
        }
//        backtracking(prepareNums, new int[nums.length], ans, 0);
        backtracking(nums, ans, 0, nums.length - 1);
        return ans;
    }

    public void backtracking(int[] prepareNums, List<List<Integer>> ans, int l, int r) {
        if (l==r) {
            ans.add(Arrays.stream(prepareNums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i=l; i <= r; i++) {
            swap(prepareNums, l, i);
            backtracking(prepareNums, ans, l + 1, r);
            swap(prepareNums, l, i);
        }
    }

    public void swap(int[] nums, int l, int r) {
        int c=nums[l];
        nums[l]=nums[r];
        nums[r]=c;
    }

    public void backtracking(Queue<Integer> prepareNums, int[] populateNums, List<List<Integer>> ans, int index) {
        Set<Integer> visited=new HashSet<>();
        if (index==populateNums.length - 1) {
            populateNums[index]=prepareNums.peek();
            ans.add(Arrays.stream(populateNums).boxed().collect(Collectors.toList()));
            return;
        }
        while (visited.size() < populateNums.length - index) {
            Integer pop=prepareNums.poll();
            if (!visited.contains(pop)) {
                visited.add(pop);
                populateNums[index]=pop;
                backtracking(prepareNums, populateNums, ans, index + 1);
                prepareNums.offer(pop);
            } else {
                prepareNums.offer(pop);
            }
        }
    }
}
