package com.code.bd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wezhyn
 * @since 09.03.2020
 */
public class HighQualityCow {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                int n = in.nextInt(), m = in.nextInt();
//                from 1 to n
                int[] cows = new int[n + 1];
                for (int mi = 1; mi <= m; mi++) {
                    int mm = in.nextInt();
                    int[] tmp = new int[n + 1];
                    for (int j = 0; j < mm; j++) {
                        int l = in.nextInt(), r = in.nextInt();
                        Arrays.fill(tmp, l, r + 1, mi);
                    }
                    for (int j = 1; j <= n; j++) {
                        if (tmp[j] == mi && cows[j] == mi - 1) {
                            cows[j]++;
                        }
                    }
                }
                int count = 0;
                final StringBuilder sb = new StringBuilder();
                for (int j = 1; j <= n; j++) {
                    if (cows[j] == m) {
                        sb.append(j);
                        count++;
                        if (j == n) {
                            sb.append("\n");
                        } else {
                            sb.append(" ");
                        }
                    }
                }
                System.out.println(count);
                System.out.println(sb.toString());
            }
        }
    }


}
