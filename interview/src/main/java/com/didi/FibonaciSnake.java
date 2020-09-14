package com.didi;

import java.util.Scanner;


/**
 * @author wezhyn
 * @since 08.21.2020
 */
public class FibonaciSnake {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            long[] fibonaci = fibonaciArrs(n);
            long[][] snake = new long[n + 1][n + 1];
            int cur = n * n;
//            起始位置 1，1 2，2 3，3
            for (int row = 1; row <= (n + 1) / 2; row++) {
                int x = row, y = row, maxY = n - x + 1;
                long num = maxY - x + 1;
                for (int i = 0; i < num; i++) {
                    snake[x][y++] = fibonaci[cur--];
                }
                if (cur == 0) {
                    break;
                }
                y--;

                for (x++; x < maxY; x++) {
                    snake[x][y] = fibonaci[cur--];
                }
                for (int i = 0; i < num; i++) {
                    snake[x][y--] = fibonaci[cur--];
                }
                y++;
                for (x--; x > row; x--) {
                    snake[x][y] = fibonaci[cur--];
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.printf("%d ", snake[i][j]);
                    if (j != n) {
                        System.out.print(" ");
                    } else {
                        System.out.print("\n");
                    }
                }
            }
        }
    }

    /**
     * 返回下标从 1 开始的数列
     *
     * @param n n*n 个元素
     * @return 斐波那契数列
     */
    private static long[] fibonaciArrs(int n) {
        long[] arr = new long[n * n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n * n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }


}
