package com.code.wanmei;

import java.util.Scanner;

/**
 * @author wezhyn
 * @since 08.25.2020
 */
public class Kbackpack {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int knapsackCapacity = Integer.parseInt(input.nextLine().trim());

        String[] volumesStr = input.nextLine().split(" ");
        int[] volumes = new int[volumesStr.length];
        for (int i = 0; i < volumesStr.length; i++) {
            volumes[i] = Integer.parseInt(volumesStr[i].trim());
        }

        String[] valuesStr = input.nextLine().split(" ");
        int[] values = new int[valuesStr.length];
        for (int i = 0; i < valuesStr.length; i++) {
            values[i] = Integer.parseInt(valuesStr[i].trim());
        }

        if (volumes.length == values.length) {
            System.out.println(method(knapsackCapacity, volumes, values));
        } else {
            System.out.println("道具数量不一致。");
        }
        input.close();
    }


    public static int method(int knapsackCapacity, int[] volumes, int[] values) {
//        dp[j][i] 表示 values[0..j] 最大 i 容量时的值
//        一件物品，可以拿与不拿
//        dp[j][i] = Max(dp[j-1][i],dp[j-1][i-volumes[i]]+values[i])

        int[][] dp = new int[values.length + 1][knapsackCapacity + 1];
        for (int i = 1; i <= knapsackCapacity; i++) {
            for (int j = 1; j <= volumes.length; j++) {
                int take;
                if (i - volumes[j - 1] < 0) {
                    take = Integer.MIN_VALUE;
                } else {
                    take = dp[j - 1][i - volumes[j - 1]] + values[j - 1];
                }
                dp[j][i] = Math.max(dp[j - 1][i], take);
            }
        }
        return dp[volumes.length][knapsackCapacity];
    }


}
