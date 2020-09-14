package com.meituan;

import java.util.Scanner;


/**
 * @author wezhyn
 * @since 08.15.2020
 */
public class TourismPath {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            boolean end = true;
            String start = "";
            int result = 0;
            for (int i = 0; i < n; i++) {
                String u = in.next(), v = in.next();
                if (end) {
                    start = u;
                    end = false;
                }
                if (v.equals(start)) {
                    end = true;
                    result++;
                }
            }
            System.out.println(result);

        }
    }

}
