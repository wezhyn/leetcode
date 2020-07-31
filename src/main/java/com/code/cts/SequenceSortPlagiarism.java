package com.code.cts;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/discuss/463769?type=0&order=0&pos=21&page=1&channel=666&source_id=discuss_center_0
 * 双路快排
 *
 * @author wezhyn
 * @see SequenceSort
 * @since 07.31.2020
 */
public class SequenceSortPlagiarism {

    static int[] data;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        data = new int[num];
        for (int i = 0; i < num; i++) {
            data[i] = sc.nextInt();
        }
        sort(0, num - 1);
    }

    public static void sort(int left, int right) {
        if (left >= right) return;
        int start = left;
        int end = right;
        int now = data[left];
        while (left < right) {
            int n;
            int m;
            while (left < right && data[right] > now) {
                right--;
            }
            while (left < right && data[left] <= now) {
                left++;
            }
            int tmp = data[right];
            data[right] = data[left];
            data[left] = tmp;
        }
        int p = data[start];
        data[start] = data[left];
        data[left] = p;
        print();
        sort(start, left - 1);
        sort(left + 1, end);
    }

    public static void print() {
        for (int i = 0; i < data.length; i++) {
            if (i == data.length - 1) {
                System.out.println(data[i]);
                return;
            }
            System.out.print(data[i] + " ");
        }
    }
}
