package com.code.bd;

import java.util.Scanner;


/**
 * 度度熊有一张网格纸，但是纸上有一些点过的点，每个点都在网格点上，若把网格看成一个坐标轴平行于网格线的坐标系的话，
 * 每个点可以用一对整数x，y来表示。度度熊必须沿着网格线画一个正方形，使所有点在正方形的内部或者边界。
 * 然后把这个正方形剪下来。问剪掉正方形的最小面积是多少
 * <p>
 * Input:
 * 第一行：n 表示点数
 * 余下n行： x,y 点的坐标
 * <p>
 * 值得注意的是 沿着网格纸进行剪裁，所以这个正方形各条边均与网格线重合
 * 所以只需要找到最小x,y和最大x,y所在的坐标
 *
 * @author wezhyn
 * @since 08.06.2020
 */
public class GridPaperTailoring {


    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {

            while (in.hasNext()) {
                int n = in.nextInt();
                int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
                for (int i = 0; i < n; i++) {
                    int x = in.nextInt();
                    int y = in.nextInt();
                    minX = Math.min(minX, x);
                    minY = Math.min(minY, y);
                    maxX = Math.max(maxX, x);
                    maxY = Math.max(maxY, y);
                }
                System.out.println(area(minX, minY, maxX, maxY));
            }
        }
    }

    private static long area(int minX, int minY, int maxX, int maxY) {
        long len = maxX - minX;
        long width = maxY - minY;
        return (long) Math.pow(Math.max(len, width), 2);
    }
}
