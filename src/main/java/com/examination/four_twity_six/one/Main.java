package com.examination.four_twity_six.one;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author wezhyn
 * @since 04.26.2020
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            Queue<Integer> queue = new LinkedList<>();
            int q = in.nextInt();
            for (int j = 0; j < q; j++) {
                String op = in.next();
                switch (op) {
                    case "PUSH": {
                        queue.offer(in.nextInt());
                        break;
                    }
                    case "TOP": {
                        final Integer peek = queue.peek();
                        System.out.println(peek == null ? -1 : peek);
                        break;
                    }
                    case "POP": {
                        if (queue.poll() == null) {
                            System.out.println(-1);
                        }
                        break;
                    }
                    case "SIZE": {
                        System.out.println(queue.size());
                        break;
                    }
                    case "CLEAR": {
                        queue.clear();
                        break;
                    }
                }
            }
        }
    }
}
