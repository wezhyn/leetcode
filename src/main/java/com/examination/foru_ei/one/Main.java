package com.examination.foru_ei.one;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean res = true;
        int roundT = in.nextInt();
        for (int i = 0; i < roundT; i++) {
            HashMap<Integer, AtomicInteger> set = new HashMap<>();
            int[][] array = new int[6][2];
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 2; k++) {
                    int pop1 = in.nextInt();
                    if (pop1 < 1 || pop1 > 10000) {
                        break;
                    }
                    array[j][k] = pop1;
                    set.putIfAbsent(pop1, new AtomicInteger(0));
                    set.get(pop1).getAndIncrement();
                }
            }
            switch (set.size()) {
                case 1: {
                    for (AtomicInteger value : set.values()) {
                        if (value.get() != 12) {
                            res = false;
                        }
                    }
                    break;
                }
                case 2: {
                    boolean isEight = false;
                    int twice = 0;
                    for (AtomicInteger value : set.values()) {
                        if (value.get() == 8) {
                            isEight = true;
                            break;
                        }
                    }
                    for (int j = 0; j < 6; j++) {
                        if (array[j][0] == array[j][1]) {
                            twice++;
                        }
                    }
                    res = isEight && twice == 2;
                    break;
                }
                case 3: {
                    res = true;
                    for (AtomicInteger value : set.values()) {
                        if (value.get() != 4) {
                            res = false;
                            break;
                        }
                    }
                    for (int j = 0; j < 6; j++) {
                        if (array[j][0] == array[j][1]) {
                            res = false;
                            break;
                        }
                    }
                    break;
                }
                default: {
                    res = false;
                    break;
                }
            }
            System.out.println(res ? "POSSIBLE" : "IMPOSSIBLE");
        }
    }
}