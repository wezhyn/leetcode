package com.code.jd;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


/**
 * 现有一个正整数，希望去掉这个数中某一个数字之后可以得到一个回文素数。
 * <p>
 * 回文素数是指一个素数同时还是一个回文数（回文数即从左到右和从右到左均一样的数，例如 12321）。【注意：一位数也被认为是回文数】
 * <p>
 * 输入两个正整数 N 和 M，满足 N<M，请编写一个程序统计 N 和 M 之间存在多少个满足上述要求的数？
 * <p>
 * 隔天复盘，才发现缺了公告上提示的：如果删除后前导是0，删除前导0后进行计算
 * > 当时写了 1011 去掉10 后发现11自己计入了。。。愚钝
 * 所以缺了 X0*11
 * 一共有如下三种情况 X0*11 1x1 11x
 *
 * @author wezhyn
 * @since 08.06.2020
 */
public class Palindrome {

    private static Set<Integer> visited = new HashSet<>();


    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                visited.clear();
                int n = in.nextInt(), m = in.nextInt();
                if (n > m) {
                    break;
                }
                final Set<Integer> allPrimeNumber = allPrimeNumber(n, m);
                for (int prime : allPrimeNumber) {
                    primeExtend(prime, n, m);
                }
                System.out.println(visited.size());
            }
        }
    }

    /**
     * 对素数进行扩展，判断素数能否在给定区间
     *
     * @param prime 素数
     */
    private static void primeExtend(int prime, int min, int max) {
        String p = String.valueOf(prime);
        int maxLen = p.length();
//            0: x11
        for (int j = 1; j <= 9; j++) {
            int r = (int) (j * Math.pow(10, p.length()) + prime);
            if (r >= min && r <= max && !visited.contains(r)) {
                visited.add(r);
            }
        }
        for (int i = 1; i <= maxLen; i++) {
//            1:1x1 2:11x
            int afterNum = maxLen - i;
            int baseNumber = Integer.parseInt(p.substring(0, i));
            int afterNumber = Integer.parseInt(p.substring(i).equals("") ? "0" : p.substring(i));
            for (int j = 0; j <= 9; j++) {
                int r = (int) (baseNumber * Math.pow(10, afterNum + 1));
                r += j * Math.pow(10, afterNum) + afterNumber;
                if (r >= min && r <= max && !visited.contains(r)) {
                    visited.add(r);
                }
                if (r > max) {
                    break;
                }
            }
        }
    }


    private static Set<Integer> allPrimeNumber(int min, int max) {
        Set<Integer> allPrimeNumber = new TreeSet<>();
        int m = standard(max);
        for (int n = standard(min) / 10; n < m; n++) {
            boolean isBreak = false;
            for (int i = 2; i * i < n; i++) {
                if (n % i == 0) {
                    isBreak = true;
                    break;
                }
            }
            if (!isBreak && isPalindrome(n)) {
                allPrimeNumber.add(n);
            }
        }
        allPrimeNumber.remove(1);
        allPrimeNumber.remove(0);
        return allPrimeNumber;
    }

    private static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revert = 0;
        while (x > revert) {
            revert = revert * 10 + x % 10;
            x /= 10;
        }
        return x == revert || x == revert / 10;
    }

    private static int standard(int x) {
        int i = 1;
        while (i <= x) {
            i = i * 10;
        }
        return i / 10;
    }

}
