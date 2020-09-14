package com.netease;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


/**
 * 小v今年有n门课，每门都有考试，为了拿到奖学金，小v必须让自己的平均成绩至少为avg
 * 每门课由平时成绩和考试成绩组成，满分为r
 * 现在他知道每门课的平时成绩为ai ,若想让这门课的考试成绩多拿一分的话，小v要花bi 的时间复习，不复习的话当然就是0分
 * 同时我们显然可以发现复习得再多也不会拿到超过满分的分数。为了拿到奖学金，小v至少要花多少时间复习
 * <p>
 * Input: n: 课程数 r: 满分数 avg: 平均分
 * n 门课程 ：[0]: ai [1] bi
 *
 * @author wezhyn
 * @since 08.07.2020
 */
public class Scholarship {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                int n = in.nextInt(), r = in.nextInt(), avg = in.nextInt();
                int[][] courses = new int[n][2];
                int remainCourse = avg * n;
                for (int i = 0; i < n; i++) {
//                    ai 每门课剩余多少分可复习
                    int baseCourse = in.nextInt();
                    remainCourse -= baseCourse;
                    courses[i][0] = r - baseCourse;
//                    bi
                    courses[i][1] = in.nextInt();
                }
                System.out.println(compute(courses, remainCourse));
            }
        }
    }

    private static long compute(int[][] courses, int remain) {
        Arrays.sort(courses, Comparator.comparingInt(t -> t[1]));
//        greedy 贪心
        long r = remain;
        long t = 0;
        for (int i = 0; r > 0 && i < courses.length; i++) {
            int[] cs = courses[i];
            long ri = Math.min(r, cs[0]);
            r -= ri;
            t += ri * cs[1];
        }

        return t;
    }

}
