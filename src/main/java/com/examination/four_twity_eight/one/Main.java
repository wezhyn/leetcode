package com.examination.four_twity_eight.one;

import java.util.Scanner;

/**
 * @author wezhyn
 * @since 04.28.2020
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
//        顶点可达矩阵
        boolean[][] ava = new boolean[n][n];
        for (int mi = 0; mi < m; mi++) {
            int u = in.nextInt() - 1, v = in.nextInt() - 1;
            ava[u][u] = true;
            ava[v][v] = true;
            ava[u][v] = true;
            ava[v][u] = true;
        }
        populate(ava, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!ava[i][j]) {
                    System.out.println("NO");
                    break;
                }
            }
        }
        System.out.println("YES");
    }

    public static void populate(boolean[][] ava, int n) {
        boolean end = true;
        while (true) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!ava[i][j] && available(ava, i, j, n)) {
                        end = false;
                        ava[i][j] = true;
                    }
                    if (i == n - 1 && j == n - 1) {
                        if (end) {
                            return;
                        } else {
                            end = true;
                        }
                    }
                }
            }
        }

    }

    public static boolean available(boolean[][] ava, int i, int j, int n) {
        if (i == 0 && j == 0) {
            return ava[i][j + 1] || ava[i + 1][j];
        } else if (i == n - 1 && j == 0) {
            return ava[i][j + 1] || ava[i - 1][j];
        } else if (i == n - 1 && j == n - 1) {
            return ava[i - 1][j] || ava[i][j - 1];
        } else if (i == 0 && j == n - 1) {
            return ava[i][j - 1] || ava[i + 1][j - 1];
        } else if (i > 0 && j == 0) {
            return ava[i][j + 1] || ava[i + 1][j] || ava[i - 1][j];
        } else if (i > 0 && j == n - 1) {
            return ava[i][j - 1] || ava[i + 1][j] || ava[i - 1][j];
        } else if (i == 0 && j > 0) {
            return ava[i][j - 1] || ava[i][j + 1] || ava[i + 1][j];
        } else if (i == n - 1 && j > 0) {
            return ava[i][j + 1] || ava[i][j - 1] || ava[i - 1][j];
        } else {
            return ava[i][j + 1] || ava[i][j - 1] || ava[i + 1][j] || ava[i - 1][j];
        }
    }
}
