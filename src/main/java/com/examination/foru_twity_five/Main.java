package com.examination.foru_twity_five;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author wezhyn
 * @since 04.25.2020
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), s = in.nextInt(), x = in.nextInt();
        int[] number = new int[n];
        Set<String> ans = new HashSet<>();
        dfs(number, 0, s, x, 0, 0, ans);
        System.out.println(ans);
        System.out.println(ans.size() % 1000009);
    }

    public static void dfs(int[] number, int index, int s, int x, int l, int r, Set<String> ans) {
        if (index == (number.length - 1)) {
            number[number.length - 1] = s;
        }
        if (s == 0 || index == number.length - 1) {
            boolean end = false;
            for (int i = 0; i <= number.length - 3; i++) {
                if (validPrefix(number, i, x)) {
                    end = true;
                    break;
                }
            }
            if (!end) {
                ans.add(toS(number));
            }
            if (index == (number.length - 1)) {
                number[number.length - 1] = 0;
            }
            return;
        }
        for (int i = Math.min(s, 9); i >= 0; i--) {
            number[index] = i;
            if (r - l == 2) {
                if (validPrefix(number, l, x)) {
                    return;
                } else {
                    l++;
                }
            }
            dfs(number, index + 1, s - i, x, l, r + 1, ans);
        }
    }

    public static boolean validPrefix(int[] number, int i, int x) {
        if (number.length - i >= 3) {
            int num = number[i] * 100 + number[i + 1] * 10 + number[i + 2];
            return num % x != 0;
        }
        return true;
    }

    public static String toS(int[] number) {
        StringBuilder sb = new StringBuilder();
        for (int i : number) {
            sb.append(i);
        }
        return sb.toString();
    }
}
