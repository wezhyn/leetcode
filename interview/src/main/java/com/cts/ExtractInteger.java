package com.cts;

import java.util.Scanner;

/**
 * 通过 87.5%
 * <p>
 * 猜测未考虑用例：
 * 1. 0 在前
 * 1. next() 换成 nextLine() 前者不能有空格
 *
 * @author wezhyn
 * @since 07.31.2020
 */
public class ExtractInteger {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String inStr = in.next();
            StringBuilder sb = new StringBuilder();
            boolean hasNumber = false;
            boolean hasSymbol = false;
            for (int i = 0; i < inStr.length(); i++) {
                char c = inStr.charAt(i);
                if (Character.isDigit(c)) {
                    hasNumber = true;
                    sb.append(c);
                } else if (!hasNumber && c == '-') {
                    hasSymbol = !hasSymbol;
                }
            }
            if (hasSymbol) {
                System.out.println("-" + sb);
            } else {
                System.out.println(sb);
            }
        }
    }
}
