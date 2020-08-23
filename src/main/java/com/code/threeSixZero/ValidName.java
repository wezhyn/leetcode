package com.code.threeSixZero;

import java.util.Scanner;


/**
 * @author wezhyn
 * @since 08.22.2020
 */
public class ValidName {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            in.nextLine();
            int result = 0;
            for (int i = 0; i < n; i++) {
                if (valid(in.nextLine())) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }

    private static boolean valid(String name) {
        if (name.isEmpty() || name.length() > 10) {
            return false;
        }
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isAlphabetic(name.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
