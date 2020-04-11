package com.examination;

import java.util.Scanner;

/**
 * @author wezhyn
 * @since 04.10.2020
 */
public class NowCoderMain {


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            int n=scanner.nextInt(), l=scanner.nextInt();
            double ni=n/2.0;
            double nl=l;
            boolean end=false;
            while (ni >= l - 1 && !end) {
                while ( nl <= 100) {
                    double ans=(ni + ni - nl + 1)*nl/2.0;
                    if (ni==1617805) {
                        System.out.println("");
                    }
                    if (ans < n) {
                        nl++;
                    } else if (ans > n) {
                        break;
                    } else if (ans==n) {
                        print((int) ni, (int) nl);
                        end=true;
                        break;
                    }
                }
                ni--;
            }
            if (!end) {
                System.out.println("No");
            }
        }
    }

    public static void print(int i, int l) {
        for (int j=i - l + 1; j <= i; j++) {
            if (j==i) {
                System.out.printf("%d\n", j);
            } else {
                System.out.printf("%d ", j);
            }
        }
    }
}
