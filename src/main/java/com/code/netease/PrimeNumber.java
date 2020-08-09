package com.code.netease;

import java.util.Scanner;


/**
 * 求每个数最多能拆成几个素数，所以使用最小的 2-3 进行计算
 *
 * @author wezhyn
 * @since 08.08.2020
 */
public class PrimeNumber {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                int n = in.nextInt();
                int[] nums = new int[n];
                for (int i = 0; i < n; i++) {
                    nums[i] = in.nextInt();
                }
                System.out.println(computeNum(nums));
            }
        }
    }

    private static long computeNum(int[] primes) {
        long result = 0;
        for (int prime : primes) {
            result += greedy(prime);
        }
        return result;
    }

    /**
     * 任何一个数可以由 2 和 3 组成
     * 返回个数
     *
     * @param prime 素数
     * @return 组成个数
     */
    private static int greedy(int prime) {
        if (prime <= 1) {
            return 0;
        }
        if (prime % 2 == 0) {
            return prime / 2;
        } else {
            return 1 + greedy(prime - 3);
        }
    }

}
