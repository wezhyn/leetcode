package com.tecent;

import java.util.Scanner;

/**
 * @author wezhyn
 * @since 08.23.2020
 */
public class PalindromeJudge {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String str = in.nextLine();
            int q = in.nextInt();
            int[][] ques = new int[q][2];
            for (int i = 0; i < q; i++) {
                ques[i][0] = in.nextInt();
                ques[i][1] = in.nextInt();
            }

        }
    }
}
