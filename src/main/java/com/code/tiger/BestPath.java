package com.code.tiger;

/**
 * @author wezhyn
 * @since 08.16.2020
 */
public class BestPath {
    public int uniquePaths(int[][] arr) {
        int n = arr.length;
        if (n <= 0) {
            return 0;
        }
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        int[] offset = new int[]{1, 0, 1};
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 2; k++) {
                    int x = i + offset[k];
                    int y = j + offset[k + 1];
                    if (x >= n || y >= m) {
                        continue;
                    }
                    min = Math.min(min, dp[x][y]);
                }
                dp[i][j] = arr[i][j] + (min == Integer.MAX_VALUE ? 0 : min);
            }
        }
        return dp[0][0];
    }
}
