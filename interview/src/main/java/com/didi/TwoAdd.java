package com.didi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * ABC + ACC =N
 *
 * @author wezhyn
 * @since 08.21.2020
 */
public class TwoAdd {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            List<int[]> results = new ArrayList<>();
            for (int i = 1; i <= 9; i++) {
                for (int j = 0; j <= 9; j++) {
                    if (j == i) {
                        continue;
                    }
                    for (int k = 0; k <= 9; k++) {
                        if (k == i || k == j) {
                            continue;
                        }
//                        A:i,B:j,C:k
                        int abc = i * 100 + j * 10 + k;
                        int acc = i * 100 + k * 10 + k;
                        if (abc + acc == n) {
                            results.add(new int[]{abc, acc});
                        }
                    }
                }
            }
            System.out.println(results.size());
            for (int[] ints : results) {
                System.out.printf("%d %d\n", ints[0], ints[1]);
            }
        }
    }

}
