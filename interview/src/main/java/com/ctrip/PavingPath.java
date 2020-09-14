package com.ctrip;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author wezhyn
 * @since 08.15.2020
 */
public class PavingPath {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static Long[] divingBoard(int a, int b, int k) {
        Set<Long> result = new TreeSet<>();
        int ak = k, bk = 0;
        while (bk <= k) {
            result.add(((long) a * ak + b * bk));
            ak--;
            bk++;
        }
        result.remove(0L);
        return result.toArray(new Long[0]);
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long[] res;
        int _a = Integer.parseInt(in.nextLine().trim());

        int _b;
        _b = Integer.parseInt(in.nextLine().trim());

        int _k;
        _k = Integer.parseInt(in.nextLine().trim());

        res = divingBoard(_a, _b, _k);
        String value = "[]";
        if (res != null && res.length > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < res.length; i++) {
                if (i == 0) {
                    stringBuilder.append("[");
                }
                stringBuilder.append(res[i]);
                if (i == res.length - 1) {
                    stringBuilder.append("]");
                } else {
                    stringBuilder.append(",");
                }
            }
            value = stringBuilder.toString();
        }
        System.out.println(value);
    }
}
