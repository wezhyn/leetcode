package com.code.jd;

import java.util.Scanner;


/**
 * @author wezhyn
 * @since 08.06.2020
 */
public class SequenceSum {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                int n = in.nextInt();
                double sum = 0;
                for (int i = 1; i <= n; i++) {
                    sum += nth(i);
                }
                System.out.printf("%.4f", sum);
            }
        }
    }

    private static double nth(int n) {
        return 1.0 / (5 * 2 * n * (2 * n - 1));
    }

}
