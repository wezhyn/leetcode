package com.code.ke;

import java.util.Scanner;


/**
 * 染色问题 0
 * N*M 个格子
 * 保证如下：
 * 1. 全部格子染色
 * 2. 相邻颜色不同
 * 3. 颜色数相同
 * 求最少颜色数
 * <p>
 * 推理：
 * 1. 只要颜色大于等于2，就可以做到相邻颜色不同
 * 2. 要求颜色数相同，那么 颜色数x 能被 N*M 整除
 * 3. 上述两者保证了1
 * > 当 N=M=1 时 颜色数为1
 * 输出最小公约数：当 N|M =1 时，输出另外一个数
 * 其他则为最小公约数
 *
 * @author wezhyn
 * @since 08.11.2020
 */
public class SquareDye {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            for (int ti = 0; ti < t; ti++) {
                int n = in.nextInt(), m = in.nextInt();

            }
        }
    }

}
