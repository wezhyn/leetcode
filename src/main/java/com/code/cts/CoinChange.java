package com.code.cts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author wezhyn
 * @since 07.31.2020
 */
public class CoinChange {

    private static final int[] COINS_NUM = new int[]{1, 5, 10, 50, 100};

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            List<Integer> coins = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                int n = in.nextInt();
                for (int j = 0; j < n; j++) {
                    coins.add(COINS_NUM[i]);
                }
            }
            int k = in.nextInt();
            System.out.println(minCoins(coins, k));
        }
    }

    private static int minCoins(List<Integer> coins, int k) {
//        0-1背包
//        dp[i][j] 表示 第 i 个元素到达j的最小数量
//        dp[i][j]= dp[i-1][j-c]+1 , dp[i-1][j]
        int[] dp = new int[k + 1];
        Arrays.fill(dp, k + 1);
        dp[0] = 0;
        for (int c : coins) {
            for (int j = k; j >= c; j--) {
                dp[j] = Math.min(dp[j - c] + 1, dp[j]);
            }
        }
        if (dp[k] == k + 1) {
            return -1;
        } else {
            return dp[k];
        }
    }
}
