package com.code.zhongan;

import java.util.Scanner;


/**
 * @author wezhyn
 * @since 08.29.2020
 */
public class TableTennisBasket {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                String[] strs = in.nextLine().split(" ");
                int[] tables = new int[26];
                for (int i = 0; i < strs[0].length(); i++) {
                    tables[(strs[0].charAt(i) - 'A')]++;
                }
                for (int i = 0; i < strs[1].length(); i++) {
                    tables[(strs[1].charAt(i) - 'A')]--;
                }
                boolean br = false;
                for (int i = 0; i < 26; i++) {
                    if (tables[i] < 0) {
                        br = true;
                        break;
                    }
                }
                if (br) {
                    System.out.println("No");
                } else {
                    System.out.println("Yes");
                }
            }
        }
    }


}
