package com.code.ke;

import java.util.Scanner;


/**
 * @author wezhyn
 * @since 08.11.2020
 */
public class PalindromeBuilder {


    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                int n = in.nextInt();
                in.nextLine();
                char[] strs = in.nextLine().toCharArray();
                System.out.println(minModify(strs, n));
            }
        }
    }

    private static int minModify(char[] strs, int n) {
        int l, r;
        if (n <= 1) {
            return 0;
        }
        if (n % 2 == 0) {
            r = n / 2;
            l = r - 1;
        } else {
            r = n / 2 + 1;
            l = n / 2 - 1;
        }
        int result = 0;
        while (l > 0 || r < n) {
            if (strs[l] != strs[r]) {
                result++;
            }
            r++;
            l--;
        }
        return result;
    }

}
