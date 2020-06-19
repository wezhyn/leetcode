package com.examination.four_twity_six.five;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author wezhyn
 * @since 04.26.2020
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            BigInteger x = in.nextBigInteger();
            int k = in.nextInt();
            int currentDep = 1 + (int) (Math.log(x.doubleValue()) / Math.log(2));
            if (k >= currentDep) {
                System.out.println(-1);
                continue;
            }
            System.out.println(x.divide(BigInteger.valueOf((long) Math.pow(2, currentDep - k))));
        }
    }
}
