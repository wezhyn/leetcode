package com.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wezhyn
 * @since 09.08.2020
 */
public class Combinations {

    List<List<Integer>> results;

    public List<List<Integer>> combine(int n, int k) {
        results = new ArrayList<>();
        final ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(0);
        }
        backtracking(n, k, list, 0, 1);
        return results;
    }

    /**
     * 从 start 开始，向
     */
    private void backtracking(int n, int k, List<Integer> nums, int cur, int start) {
        if (cur == k) {
            results.add(new ArrayList<>(nums));
            return;
        }
        if (start > n || start + k - cur - 1 > n) {
            return;
        }
//        当前设置
        backtracking(n, k, nums, cur, start + 1);
        nums.set(cur, start);
//        当前不设置
        backtracking(n, k, nums, cur + 1, start + 1);
    }
}
