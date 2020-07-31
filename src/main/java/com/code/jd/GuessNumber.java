package com.code.jd;

import java.util.Scanner;

/**
 * 牛客Jd 面试题二
 * <p>
 * 牛牛和妞妞正在玩一个猜数游戏，妞妞心里想两个不相等的正数，把这两个正数的和 y 告诉牛牛。
 * 妞妞声称这两个数都不超过 x，让牛牛猜这两个数是多少。
 * 牛牛每猜一次，妞妞会告诉他猜对了还是猜错了，猜对了就停止游戏，猜错了就直到牛牛猜对为止。
 * 妞妞为了加大难度，有时会误报 x 的大小，如果牛牛可以判断出了这个 x 是错误的，就会直接询问妞妞答案。
 * 牛牛最坏情况下要猜多少次才能猜到妞妞想的数呢？
 * <p>
 * 输入：x,y
 * 输出n：最坏次数
 *
 * @author wezhyn
 * @since 07.31.2020
 */
public class GuessNumber {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            long x = in.nextLong(), y = in.nextLong();
//            检查x，y是否正确
            if (2 * x < y) {
                System.out.println(0);
                return;
            }
            int offset = (y & 1) == 1 ? 0 : -1;
            if (y <= x) {
                System.out.println(y / 2 + offset);
            } else {
                System.out.println(x - y / 2 + offset);
            }
        }
    }
}
