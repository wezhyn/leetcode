package com.code.netease;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 注意边界条件的判断
 *
 * @author wezhyn
 * @since 08.09.2020
 */
public class StreetLamp {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                int n = in.nextInt();
                long l = in.nextInt();
                int[] lamps = loadNums(n, in);
                Arrays.sort(lamps);
//                找到相聚最远的距离的连续路灯
                long max = Long.MIN_VALUE;
                for (int i = 0; i < lamps.length - 1; i++) {
                    max = Math.max(max, lamps[i + 1] - lamps[i]);
                }
                if (2 * lamps[0] >= max || 2 * (l - lamps[n - 1]) >= max) {
                    System.out.printf("%.2f\n", Math.max(lamps[0], l - lamps[n - 1]) * 1.0);
                } else {
                    System.out.printf("%.2f\n", max / 2.0);
                }
            }
        }
    }

    private static int[] loadNums(int n, Scanner in) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        return nums;
    }

}
