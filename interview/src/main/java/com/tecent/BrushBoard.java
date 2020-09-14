package com.tecent;

import java.util.Scanner;


/**
 * 对于给定板子，有两种刷法：
 * 1. 把某一个长板往下刷一次
 * 2. 全部横着刷一次
 *
 * @author wezhyn
 * @since 08.23.2020
 */
public class BrushBoard {


    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int[] boards = loadNums(n, in);
            System.out.println(dfs(boards, 0, n - 1));
        }
    }

    private static long dfs(int[] boards, int l, int r) {
        if (l > r) {
            return 0;
        }
        int val = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            if (boards[i] < val) {
                val = boards[i];
            }
        }
        long diff = r - l + 1;
        if (val >= diff) {
            return diff;
        } else {
            int pre = l;
            long result = val;
            for (int i = l; i <= r; i++) {
                boards[i] -= val;
                if (boards[i] == 0) {
                    result += dfs(boards, pre, i - 1);
                    pre = i + 1;
                }
            }
            if (pre <= r) {
                result += dfs(boards, pre, r);
            }
            return result;
        }
    }

    private static int[] loadNums(int n, Scanner in) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        return nums;
    }


}
