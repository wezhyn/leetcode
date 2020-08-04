package com.code.bd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author wezhyn
 * @since 08.04.2020
 */
public class FishingGame {

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            double cc;
            double sum;
            String str;
            while ((str = in.readLine()) != null) {
                String[] strs = str.split(" ");
                int n = Integer.parseInt(strs[0]), m = Integer.parseInt(strs[1]), x = Integer.parseInt(strs[2]);
                int y = Integer.parseInt(strs[3]), t = Integer.parseInt(strs[4]);
                cc = 0;
                sum = 0;
                for (int i = 0; i < n; i++) {
                    strs = in.readLine().split(" ");
                    for (int j = 0; j < m; j++) {
                        final double aDouble = Double.parseDouble(strs[j]);
                        if (i == x - 1 && j == y - 1) {
                            cc = aDouble;
                        }
                        sum += aDouble;
                    }
                }
                double ss = sum / (n * m);
                double pcc = 1 - Math.pow(1 - cc, t);
                double pss = 1 - Math.pow(1 - ss, t);
                if (cc - ss > 0) {
                    System.out.printf("cc\n%.2f\n", pcc);
                } else if (cc - ss < 0) {
                    System.out.printf("ss\n%.2f\n", pss);
                } else {
                    System.out.printf("equal\n%.2f\n", pss);
                }
            }
        }
    }
}
