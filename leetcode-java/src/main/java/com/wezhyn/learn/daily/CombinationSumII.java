package com.wezhyn.learn.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wezhyn
 * @since 09.10.2020
 */
public class CombinationSumII {

    private List<List<Integer>> results;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashMap<Integer, int[]> nums = new HashMap<>();
        for (int i : candidates) {
            nums.computeIfAbsent(i, kk -> new int[]{0})[0]++;
        }
        List<int[]> pairs = new ArrayList<>();
        for (Map.Entry<Integer, int[]> entry : nums.entrySet()) {
            pairs.add(new int[]{entry.getKey(), entry.getValue()[0]});
        }
        List<Integer> containers = new ArrayList<>();
        results = new ArrayList<>();
        backtracking(pairs, target, containers, 0);
        return results;
    }

    private void backtracking(List<int[]> candidates, int remain, List<Integer> elements, int cur) {
        if (remain == 0) {
            results.add(new ArrayList<>(elements));
            return;
        } else if (remain < 0 || cur >= candidates.size()) {
            return;
        }
        final int[] pair = candidates.get(cur);
        for (int i = 0; i <= pair[1] && remain - pair[0] * i >= 0; i++) {
            for (int j = 1; j <= i; j++) {
                elements.add(pair[0]);
            }
            backtracking(candidates, remain - pair[0] * i, elements, cur + 1);
            for (int j = 1; j <= i; j++) {
                elements.remove(elements.size() - 1);
            }
        }
    }
}
