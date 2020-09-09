package com.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wezhyn
 * @since 09.09.2020
 */
public class CombinationSum {

    private List<List<Integer>> results;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> containers = new ArrayList<>();
        results = new ArrayList<>();
        backtracking(candidates, target, containers, 0);
        return results;
    }

    private void backtracking(int[] candidates, int remain, List<Integer> elements, int cur) {
        if (remain < 0 || cur >= candidates.length) {
            return;
        } else if (remain == 0) {
            results.add(new ArrayList<>(elements));
            return;
        }
        backtracking(candidates, remain, elements, cur + 1);
        final int ele = candidates[cur];
        if (remain - ele >= 0) {
            elements.add(candidates[cur]);
            backtracking(candidates, remain - ele, elements, cur);
            elements.remove(elements.size() - 1);
        }
    }
}
