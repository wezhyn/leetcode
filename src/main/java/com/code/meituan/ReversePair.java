package com.code.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 小团最近对逆序数（将一个数字逐位逆序，例如 1234 的逆序数为 4321）特别感兴趣，但是又觉得普通的逆序数问题有点太乏味了。
 * <p>
 * 于是他想出了一个新的定义：如果一个数的 4 倍恰好是它的逆序数，那么称这两个数是新定义下的逆序对。
 * <p>
 * 接下来给定一正整数 n，问：不超过 n 的正整数中有多少对新定义下的逆序对？
 * <p>
 *
 * @author wezhyn
 * @since 08.15.2020
 */
public class ReversePair {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            List<int[]> result = new ArrayList<>();
            for (int i = 2000; i < n / 4; i += 2) {
                int reverseI = 4 * i;
                if (reverse(i) == reverseI) {
                    result.add(new int[]{i, reverseI});
                }
            }
            System.out.println(result.size());
            for (int[] ints : result) {
                System.out.printf("%d %d\n", ints[0], ints[1]);
            }
        }

    }

    public static int reverse(int i) {
        int result = 0;
        while (i > 0) {
            result *= 10;
            result += i % 10;
            i /= 10;
        }
        return result;
    }


}
