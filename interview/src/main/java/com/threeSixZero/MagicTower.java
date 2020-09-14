package com.threeSixZero;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author wezhyn
 * @since 08.24.2020
 */
public class MagicTower {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            List<Integer> tower = new ArrayList<>();
            long score = 0;
            for (int i = 0; i < n; i++) {
                int s = in.nextInt();
                int b = in.nextInt();
                if (b == 0) {
                    score += s;
                } else {
                    tower.add(s);
                }
            }
            tower.sort(Comparator.reverseOrder());
            for (int i : tower) {
                if (i > score) {
                    score += i;
                } else {
                    score *= 2;
                }
            }
            System.out.println(score);
        }
    }
}
