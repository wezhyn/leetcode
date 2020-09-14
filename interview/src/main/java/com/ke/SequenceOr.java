package com.ke;

import java.util.Scanner;


/**
 * AC
 *
 * @author wezhyn
 * @since 08.11.2020
 */
public class SequenceOr {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                int n = in.nextInt();
                int[] nums = new int[n];
                int maxOr = 0;
                for (int i = 0; i < n; i++) {
                    int num = in.nextInt();
                    nums[i] = num;
                    maxOr |= num;
                }
                System.out.println(min(nums, n, maxOr));
            }
        }
    }

    private static int min(int[] nums, int n, int maxOr) {
//                dp[i][j] 表示从 arr[i] 到 arr[j] 的 or
//                dp[i][j] = dp[i][j-1]|arr[j]
        int[] dp = new int[n];
        int minLen = Integer.MAX_VALUE;
        for (int step = 0; step < n; step++) {
            for (int i = n - 1 - step; i >= 0; i--) {
                int j = i + step;
                int pre = j - 1 < i ? 0 : dp[j - 1];
                dp[j] = pre | nums[j];
                if (dp[j] >= maxOr) {
                    minLen = Math.min(minLen, j - i + 1);
                    return minLen;
                }
            }
        }
        return minLen;
    }
}
