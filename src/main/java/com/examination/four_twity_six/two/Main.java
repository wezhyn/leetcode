package com.examination.four_twity_six.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wezhyn
 * @since 04.26.2020
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            List<Pair> pairsA = read(in, n);
            List<Pair> pairsB = read(in, n);
            double min = Double.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                Pair a = pairsA.get(j);
                for (int k = 0; k < n; k++) {
                    Pair b = pairsB.get(k);
                    double res = Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow(a.y - b.y, 2));
                    min = Math.min(res, min);
                }
            }
            System.out.printf("%.3f\n", min);
        }
    }

    public static List<Pair> read(Scanner scanner, int n) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            pairs.add(new Pair(x, y));
        }
        return pairs;
    }

    public static class Pair {
        long x;
        long y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
