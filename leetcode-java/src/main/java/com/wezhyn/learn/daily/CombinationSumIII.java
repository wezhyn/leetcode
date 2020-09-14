package com.wezhyn.learn.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wezhyn
 * @since 09.11.2020
 */
public class CombinationSumIII {


    private List<List<Integer>> results;


    public List<List<Integer>> combinationSum3(int k, int n) {
        results = new ArrayList<>();
        backtracking(k, n, 1, new ArrayList<>());
        return results;
    }

    private void backtracking(int remainK, int remainN, int cur, List<Integer> containers) {
        if (remainK == 0 && remainN == 0) {
            results.add(new ArrayList<>(containers));
        }
        if (cur > 9 || remainK < 0 || remainN < 0 || remainN < cur) {
            return;
        }
        containers.add(cur);
        backtracking(remainK - 1, remainN - cur, cur + 1, containers);
        containers.remove(containers.size() - 1);
        backtracking(remainK, remainN, cur + 1, containers);
    }
}
