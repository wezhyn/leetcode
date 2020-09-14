package com.wezhyn.learn.array;

/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * <p>
 * 不占用额外内存空间能否做到？
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 *
 * @author wezhyn
 * @since 08.29.2020
 */
public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            int minX = i, maxX = n - i - 1;
            for (int j = i; j <= maxX - 1; j++) {
                int tmp = matrix[i][j];
                matrix[minX][j] = matrix[n - 1 - j][minX];
                matrix[n - 1 - j][minX] = matrix[maxX][n - 1 - j];
                matrix[maxX][n - 1 - j] = matrix[j][maxX];
                matrix[j][maxX] = tmp;
            }
        }
    }
}
