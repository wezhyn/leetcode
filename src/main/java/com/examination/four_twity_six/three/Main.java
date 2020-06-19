package com.examination.four_twity_six.three;

import java.util.Scanner;

/**
 * @author wezhyn
 * @since 04.26.2020
 */
public class Main {
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Pair[] pairs = read(in, n);
        int m = Integer.MAX_VALUE;
        for (int i = 1; i < 20; i++) {
            min = Integer.MAX_VALUE;
            dfs(pairs, i, 0, i);
            m = Math.min(m, min);
        }
        System.out.println(m);
    }

    public static void dfs(Pair[] pairs, int n, int index, int origin) {
        if (n == 0 || index == pairs.length - 2) {
            if (valid(pairs)) {
                min = Math.min(min, origin);
            }
        }
        for (int i = index + 1; i < pairs.length - 2; i++) {
            swap(pairs, index, i);
            dfs(pairs, n - 1, index + 1, origin);
            swap(pairs, index, i);
        }
    }

    public static void swap(Pair[] pairs, int l, int r) {
        Pair p = pairs[l];
        pairs[l] = pairs[r];
        pairs[r] = p;
        pairs[l].positive();
        p.positive();
    }

    public static boolean valid(Pair[] pairs) {
        for (int i = 0; i < pairs.length - 2; i++) {
            if (pairs[i].get() > pairs[i + 1].get()) {
                return false;
            }
        }
        return true;
    }

    public static Pair[] read(Scanner in, int n) {
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(in.nextInt(), -1);
        }
        for (int i = 0; i < n; i++) {
            pairs[i].setY(in.nextInt());
        }
        return pairs;
    }

    private static class Pair {
        boolean positive;
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
            this.positive = true;
        }

        public int get() {
            return positive ? x : y;
        }

        public void setX(int x) {
            this.x = x;
        }


        public void setY(int y) {
            this.y = y;
        }

        public void positive() {
            this.positive = !positive;
        }
    }
}
