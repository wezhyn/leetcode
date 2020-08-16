package com.code.meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * @author wezhyn
 * @since 08.15.2020
 */
public class VehicleScheduling {


    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                int n = in.nextInt(), a = in.nextInt(), b = in.nextInt();
                Pair[] pairs = new Pair[n];
                for (int i = 0; i < n; i++) {
                    pairs[i] = new Pair(in.nextInt(), in.nextInt());
                }
                System.out.println(Math.max(maxB(pairs, n, a, b), maxA(pairs, n, a, b)));
            }
        }

    }

    public static int maxB(Pair[] pairs, int n, int a, int b) {
        int result = 0;
        Arrays.sort(pairs, (p1, p2) -> {
            if (p1.b == p2.b) {
                return p1.a - p2.a;
            }
            return p2.b - p1.b;
        });
        List<Pair> integers = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            result += pairs[i].b;
            pairs[i].copy = pairs[i].a;
            pairs[i].a = 0;
            integers.add(pairs[i]);
        }
        Arrays.sort(pairs, (p1, p2) -> p2.a - p1.a);
        for (int i = 0; i < b; i++) {
            result += pairs[i].a;
        }
        for (Pair integer : integers) {
            integer.a = integer.copy;
        }
        return result;

    }

    public static int maxA(Pair[] pairs, int n, int a, int b) {
        int result = 0;
        Arrays.sort(pairs, (p1, p2) -> {
            if (p1.a == p2.a) {
                return p1.b - p2.b;
            }
            return p2.a - p1.a;
        });
        List<Pair> integers = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            result += pairs[i].a;
            pairs[i].copy = pairs[i].b;
            pairs[i].b = 0;
            integers.add(pairs[i]);
        }
        Arrays.sort(pairs, (p1, p2) -> p2.b - p1.b);
        for (int i = 0; i < b; i++) {
            result += pairs[i].b;
        }
        for (Pair integer : integers) {
            integer.b = integer.copy;
        }
        return result;

    }

    public static class Pair {
        int a;
        int b;
        int copy;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }


}
