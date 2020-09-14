package com.wezhyn.learn.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wezhyn
 * @since 09.03.2020
 */
public class NQueens {


    private List<List<String>> results;
    private int[] queen;

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        results = new ArrayList<>();
        queen = new int[n];
        backtracking(0, n);
        return results;
    }

    private void backtracking(int level, int maxLevel) {
        if (level >= maxLevel) {
            results.add(queensToString(maxLevel));
        }
        int[] possibles = new int[maxLevel];
        for (int i = 0; i < level; i++) {
            int queenRow = i, queueColumn = queen[queenRow];
            possibles[queueColumn] = 1;
            if (queueColumn + level - i < maxLevel) {
                possibles[queueColumn + (level - i)] = 1;
            }
            if (queueColumn - (level - i) >= 0) {
                possibles[queueColumn - level + i] = 1;
            }
        }
        for (int i = 0; i < possibles.length; i++) {
            if (possibles[i] == 0) {
                queen[level] = i;
                backtracking(level + 1, maxLevel);
            }
        }

    }

    private List<String> queensToString(int n) {
        List<String> results = new ArrayList<>();
        char[] chars = new char[n];
        Arrays.fill(chars, '.');
        for (int i = 0; i < n; i++) {
            chars[queen[i]] = 'Q';
            results.add(new String(chars));
            chars[queen[i]] = '.';
        }
        return results;
    }


}
