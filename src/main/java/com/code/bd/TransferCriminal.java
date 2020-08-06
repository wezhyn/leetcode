package com.code.bd;

import java.util.Scanner;


/*
 * C市现在要转移一批罪犯到D市，C市有n名罪犯，按照入狱时间有顺序，另外每个罪犯有一个罪行值，值越大罪越重。
 * 现在为了方便管理，市长决定转移入狱时间连续的c名犯人，同时要求转移犯人的罪行值之和不超过t，问有多少种选择的方式
 *
 * 转移连续的罪罚，意味着求原数组的连续子数组，使其和小于 t
 * 常规思路：arr[i]+arr[i+1]+arr[n] 会造成 某个区间重复计算
 * 使用双指针模式，使用一个sum保存这个 c 个数之和
 * @author wezhyn
 * @since 08.06.2020
 */
public class TransferCriminal {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                int n = in.nextInt(), t = in.nextInt(), c = in.nextInt();
                int[] criminals = new int[n];
                for (int i = 0; i < n; i++) {
                    criminals[i] = in.nextInt();
                }
                int sum = 0;
                for (int i = 0; i < c; i++) {
                    if (i >= n) {
                        System.out.println(sum <= t ? 1 : 0);
                    }
                    sum += criminals[i];
                }
                int result = sum <= t ? 1 : 0;
                for (int i = c; i < n; i++) {
                    sum = sum - criminals[i - c] + criminals[i];
                    if (sum <= t) {
                        result++;
                    }
                }
                System.out.println(result);
            }
        }
    }

}
