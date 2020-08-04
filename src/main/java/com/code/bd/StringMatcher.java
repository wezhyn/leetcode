package com.code.bd;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * 给定字符串 s，和 匹配字符串 p，给出 s 中 p 出现的次数
 * > ? 代表 0 或者 1
 * Input: s：00010001 p: ??
 * Output：3
 * > 出现 00，01，10 但没有出现 11
 *
 * @author wezhyn
 * @since 08.02.2020
 */
public class StringMatcher {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String s = in.next(), p = in.next();
            Set<String> strings = new HashSet<>();
            if (s.length() < p.length()) {
                System.out.println(0);
                return;
            }
            for (int i = 0; i <= s.length() - p.length(); i++) {
                boolean isBreak = false;
                for (int j = 0; j < p.length(); j++) {
                    if (p.charAt(j) != '?' && s.charAt(i + j) != p.charAt(j)) {
                        isBreak = true;
                        break;
                    }
                }
                if (!isBreak) {
                    strings.add(s.substring(i, i + p.length()));
                }
            }
            System.out.println(strings.size());
        }
    }

}
