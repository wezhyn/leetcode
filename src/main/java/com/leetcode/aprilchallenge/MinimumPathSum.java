package com.leetcode.aprilchallenge;

/**
 * @author wezhyn
 * @since 04.19.2020
 */
public class MinimumPathSum {


    public int minPathSum(Integer[][] grid) {
        Integer[][] sum = grid.clone();
        if (grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        if (columns == 0) {
            return 0;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int top = i == 0 ? Integer.MAX_VALUE : sum[i - 1][j];
                int left = j == 0 ? Integer.MAX_VALUE : sum[i][j - 1];
                int s = Math.min(top, left) == Integer.MAX_VALUE ? 0 : Math.min(top, left);
                sum[i][j] = sum[i][j] + s;
            }
        }
        return sum[rows - 1][columns - 1];
    }
}
