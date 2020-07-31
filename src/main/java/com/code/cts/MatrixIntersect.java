package com.code.cts;


import java.util.Scanner;

/**
 * 给定两个矩阵，判断是否相交
 * <p>
 * 100 AC
 *
 * @author wezhyn
 * @since 07.31.2020
 */
public class MatrixIntersect {

    public static void main(String[] args) {

        try (final Scanner in = new Scanner(System.in)) {
            Matrix fm = new Matrix(in);
            Matrix sm = new Matrix(in);
//            交换 fm,sm 使得fm 的 start 是最左下边的
            if (!fm.start.isLeft(sm.start) && fm.start.isUp(sm.start)) {
                Matrix tmp = fm;
                fm = sm;
                sm = tmp;
            }
//            检查相交
            for (int yi = fm.start.y; yi < sm.end.y; yi++) {
                if (fm.inMatrix(new Pair(sm.start.x, yi))) {
                    System.out.println(1);
                    return;
                }
            }
            System.out.println(0);

        }
    }


    private static class Matrix {
        Pair start;
        Pair end;

        public Matrix(Scanner scanner) {
//            保持 start 在 end 左边
            this.start = new Pair(scanner);
            this.end = new Pair(scanner);
            if (!start.isLeft(end)) {
                Pair tmp = end;
                end = start;
                start = tmp;
            }
        }

        public boolean inMatrix(Pair pair) {
            return pair.y >= start.y && pair.y <= end.y && pair.x >= start.x && pair.x <= end.x;
        }
    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair(Scanner scanner) {
            this.x = scanner.nextInt();
            this.y = scanner.nextInt();
        }


        public boolean isLeft(Pair o) {
            return x < o.x;
        }

        public boolean isUp(Pair o) {
            return y > o.y;
        }
    }


}
