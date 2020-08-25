package com.code.tecent;

import java.util.Scanner;

/**
 * @author wezhyn
 * @since 08.23.2020
 */
public class NumberBitSum {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            for (int ti = 0; ti < t; ti++) {
                long maxNum = 0;
                long n = in.nextLong();
                long l = n / 2;
                while (l > 0) {
                    long diff = n - l;
                    long sum = numSum(l, diff);
                    if (sum >= maxNum) {
                        l /= 10;
                        maxNum = sum;
                    } else {
                        l = l - 3;
                    }
                }
                System.out.println(maxNum);
            }
        }
    }

    private static long numSum(long one, long two) {
        long sum = 0;
        while (one > 0) {
            long r = one % 10;
            sum += r;
            one /= 10;
        }
        while (two > 0) {
            long r = two % 10;
            sum += r;
            two /= 10;
        }
        return sum;
    }
}
