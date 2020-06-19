package com.leetcode.aprilchallenge;

/**
 * @author wezhyn
 * @since 04.18.2020
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int num = 0;
        if (grid == null) {
            return num;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                num += islands(grid, i, j, grid.length - 1, grid[i].length - 1);
            }
        }
        return num;
    }

    private int islands(char[][] grid, int m, int n, int maxLine, int maxColumn) {
        int result = 0;
        if (m < 0 || n < 0 || m > maxLine || n > maxColumn) {
            return 0;
        }
        if (grid[m][n] == '1') {
            result = 1;
            grid[m][n] = 0;
            islands(grid, m + 1, n, maxLine, maxColumn);
            islands(grid, m - 1, n, maxLine, maxColumn);
            islands(grid, m, n + 1, maxLine, maxColumn);
            islands(grid, m, n - 1, maxLine, maxColumn);
        } else {
            return result;
        }
        return result;
    }
}
