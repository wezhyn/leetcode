package com.bd;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 一个花坛中有很多花和两个喷泉。
 * <p>
 * 喷泉可以浇到以自己为中心，半径为 r 的圆内的所有范围的花。
 * <p>
 * 现在给出这些花的坐标和两个喷泉的坐标，要求你安排两个喷泉浇花的半径 r1 和 r2，
 * 使得所有的花都能被浇到的同时， r12 + r22 的值最小。
 * <p>
 * 通过对每个点计算最小r
 * <p>
 * 原 10%
 * 缺失1：当 r1 扫描的部分区域已经可以被r2扫描【观察用例得知】60%
 * <p>
 * 缺失2：点的大小关系，如果两个点，一个点到达f1,f2的距离是100 ，随机赋予任意一个花坛【f1】，但接下来一个点，距离f1 150 ,f2 50
 * 加起来150 ，但实际上 第一个点100赋予f2 能使距离最小,但也会出现 缺失1的问题
 * <p>
 * 40分钟挑战失败
 * 1. 使用到某个花坛的距离进行一次排序,并且是从大到小排序，从小到大排序会使得 某个花到f1近，但是会被之后大范围的f2覆盖
 * 2. 随之 r1,r2的比较也失效，因为最开始到r1的实际上是最大距离
 *
 * @author wezhyn
 * @since 08.01.2020
 */
public class WaterFlower {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
//            初始化数据
            int n = in.nextInt();
            final FlowerBed fb = new FlowerBed(in.nextInt(), in.nextInt());
            final FlowerBed sb = new FlowerBed(in.nextInt(), in.nextInt());
            long[][] flowers = new long[n][2];

            for (int i = 0; i < n; i++) {
                flowers[i][0] = in.nextLong();
                flowers[i][1] = in.nextLong();
            }
            Arrays.sort(flowers, (f1, f2) -> distance(f1, fb) - distance(f2, fb) >= 0 ? -1 : 1);
            long res = Long.MAX_VALUE;
            long r2 = 0;
            for (long[] flower : flowers) {
//              r1+r2
                res = Math.min(res, distance(flower,fb) + r2);
                r2 = Math.max(r2, distance(flower, sb));
            }
//            即可能 r1+r2> r2 ，但f2 能浇到所有花
            System.out.println(Math.min(res, r2));
        }
    }

    private static long distance(long[] flower, FlowerBed flowerBed) {
        return (long) (Math.pow(flowerBed.x - flower[0], 2) + Math.pow(flowerBed.y - flower[1], 2));
    }


    private static class FlowerBed {
        int x;
        int y;

        public FlowerBed(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
