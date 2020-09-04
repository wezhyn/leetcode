package com.code.bd;

import java.util.Scanner;

/**
 * @author wezhyn
 * @since 09.03.2020
 */
public class MaxNum {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int zeroNum = 0, fiveNum = 0, n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int ai = in.nextInt();
                if (ai == 0) {
                    zeroNum++;
                } else {
                    fiveNum++;
                }
            }
            if (zeroNum == 0 || fiveNum < 9) {
                System.out.println(-1);
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < fiveNum / 9; i++) {
                sb.append("555555555");
            }
            for (int i = 0; i < zeroNum; i++) {
                sb.append("0");
            }
            System.out.println(sb);
        }
    }
}
