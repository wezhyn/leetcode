package com.netease;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，
 * 要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大
 * Input:
 * 第一行 ： n
 * 第 2 行： n 个能力
 * 第三行：k,d
 * <p>
 * 使用dp[k][j] 表示经过k个学生到达 J 的最大值 arr[j] 必选
 * dp[k][j] = dp[k-1][j-d]*arr[j]
 * 复杂度 d* n * k
 * <p>
 * 有正负号时，尽量使用 Pair 包含最大正数和最小负数 减少复杂度
 * <p>
 *
 * @author wezhyn
 * @since 08.11.2020
 */
public class Choir {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                int n = in.nextInt();
                int[] stus = loadNums(n, in);
                int k = in.nextInt(), d = in.nextInt();
//                 dp[i] 表达
                Pair[][] dp = new Pair[k + 1][n];
                for (int i = 0; i < dp.length; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i == 0) {
                            dp[i][j] = new Pair(0, 1);
                        } else {
                            dp[i][j] = new Pair(0, 0);
                        }
                    }
                }
                dp[1][0].positive = stus[0];
                for (int ki = 1; ki <= k; ki++) {
                    for (int i = 0; i < n; i++) {
                        for (int di = 1; di <= d && i - di >= 0; di++) {
                            long ng = dp[ki - 1][i - di].negative * stus[i];
                            long ps = dp[ki - 1][i - di].positive * stus[i];
                            dp[ki][i].negative = min(true, ng, ps, dp[ki][i].negative);
                            dp[ki][i].positive = min(false, ng, ps, dp[ki][i].positive);
                        }
                    }
                }
                long max = Integer.MIN_VALUE;
                for (int i = k - 1; i < n; i++) {
                    if (dp[k][i].positive > 0) {
                        max = Math.max(dp[k][i].positive, max);
                    } else {
                        max = Math.max(dp[k][i].negative, max);
                    }
                }
                System.out.println(max);
            }
        }
    }

    private static long min(boolean min, long... nums) {
        if (min) {
            return Arrays.stream(nums).min().getAsLong();
        } else {
            return Arrays.stream(nums).max().getAsLong();
        }
    }

    private static int[] loadNums(int n, Scanner in) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        return nums;
    }

    private static class Pair {
        long negative;
        long positive;

        public Pair(int negative, int positive) {
            this.negative = negative;
            this.positive = positive;
        }
    }
}
