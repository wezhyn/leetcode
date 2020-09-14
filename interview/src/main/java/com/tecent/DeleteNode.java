package com.tecent;

import java.util.Scanner;

/**
 * @author wezhyn
 * @since 08.23.2020
 */
public class DeleteNode {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt(), k = in.nextInt();
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                int next = in.nextInt();
                if (i != k) {
                    sb.append(next);
                } else {
                    continue;
                }
                if (i != n) {
                    sb.append(" ");
                }
            }
            System.out.println(sb);
        }
    }
}
