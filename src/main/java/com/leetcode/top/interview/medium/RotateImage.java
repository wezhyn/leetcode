package com.leetcode.top.interview.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * 正方形旋转规则：(i,j)->(j,n-1-i)->(n-1-i,n-1-j)->(n-1-j,i)->(i,y)
 *
 * @author wezhyn
 * @since 04.12.2020
 */
public class RotateImage {

    @Test
    public void test() {
        int[][] matrix=new int[][]{{1}};
        rotate(matrix);
        Arrays.stream(matrix).forEach(a->System.out.println(Arrays.toString(a)));
    }

    public void rotate(int[][] matrix) {
        int len=matrix.length - 1;
//        4 遍历 0,1  5遍历 0，1
        for (int i=0; i < matrix.length/2; i++) {
            for (int j=i; j < matrix.length - i - 1; j++) {
                int top=matrix[i][j];
                int right=matrix[j][len - i];
                int down=matrix[len - i][len - j];
                int left=matrix[len - j][i];
                matrix[j][len - i]=top;
                matrix[len - i][len - j]=right;
                matrix[len - j][i]=down;
                matrix[i][j]=left;
            }
        }
    }
}
