package com.examination.fourZeroNine.three;

import java.util.Scanner;

/**
 * @author wezhyn
 * @since 04.09.2020
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            int n=scanner.nextInt();
            int k=scanner.nextInt();
            int min=Integer.MAX_VALUE;
            int l=0, r=n;
            while (l < r) {
                int x=(l + r)/2;
                final int canComplete=canComplete(x, k);
                if (canComplete==n) {
                    r=x;
                    min=Math.min(min, x);
                } else if (canComplete < n) {
                    l=x + 1;
                } else {
                    r=x - 1;
                }
            }
            System.out.println(min);
        }
    }

    private static int canComplete(int x, int k) {
        int i=0;
        int c=0;
        int kk=(int) Math.pow(k, i);
        while (x/kk!=0) {
            c+=x/kk;
            kk=(int) Math.pow(k, ++i);
        }
        return c;
    }
}
