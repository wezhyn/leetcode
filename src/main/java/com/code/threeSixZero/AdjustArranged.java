package com.code.threeSixZero;

import java.util.Scanner;

/**
 * 输入：N,M
 * N 表示构建一个 [1..N]的数组，N 一定是偶数
 * M 表示操作队列[ 1,2,1,2]
 * 操作1 ： 将队列首元素移到末尾
 * 操作2 ：将 1-2 3-4  N-1,N 元素互换  *
 * 1、准备两个链表，一个奇数链表a，一个偶数链表b
 * 2、关于方式一，a链表第一个移动到b链表最后一个位置；b链表第一个替换原先a链表第一个位置
 * 3、关于方式二，其实交换的目的只是在输出是决定先输出a第一个还是b的第一个，然后两个链表交叉输出
 *
 * @author wezhyn
 * @since 08.22.2020
 */
public class AdjustArranged {

    private static final int MOVE_NUM = 1;

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt(), m = in.nextInt();
            int[] arr = new int[n + MOVE_NUM + 1];
            for (int i = 0; i < n; i++) {
                arr[i] = i + 1;
            }
            int l = 0, r = n - 1;
            int lastOperate = -1;
            for (int i = 0; i < m; i++) {
                int cur = in.nextInt();
                if (lastOperate == 2 && cur == 2) {
                    lastOperate = -1;
                } else if (lastOperate == -1 && cur == 1) {
                    operate1(arr, l++, ++r);
                } else if (lastOperate == -1 && cur == 2) {
                    lastOperate = 2;
                } else {
//                    last=2 cur =1
                    operate2(arr, l, r);
                    operate1(arr, l++, ++r);
                    lastOperate = -1;
                }
                if (r >= n + MOVE_NUM) {
                    System.arraycopy(arr, l, arr, 0, r - l + 1);
                    l = 0;
                    r = n - 1;
                }
            }
            if (lastOperate == 2) {
                operate2(arr, l, r);
            }
            print(arr, l, r);
        }
    }

    private static void operate2(int[] arr, int l, int r) {
        for (int step = 0; step <= r - 1; step += 2) {
            int tmp = arr[l + step];
            arr[l + step] = arr[l + step + 1];
            arr[l + step + 1] = tmp;
        }
    }

    private static void operate1(int[] arr, int l, int r) {
        arr[r] = arr[l];
    }

    private static void print(int[] arr, int l, int r) {
        StringBuilder sb = new StringBuilder();
        for (int i = l; i <= r; i++) {
            sb.append(arr[i]);
            if (i == r) {
                sb.append("\n");
            } else {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
