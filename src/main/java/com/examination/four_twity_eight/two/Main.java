package com.examination.four_twity_eight.two;


import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author wezhyn
 * @since 04.28.2020
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int ti = 0; ti < t; ti++) {
            String s = in.next();
            if (s.length() % 2 != 0 || s.length() == 0) {
                System.out.println("No");
                continue;
            }
            Queue<Character> charactersA = new LinkedList<>();
            Character endPoint = Character.MAX_VALUE;
            Queue<Character> charactersEmpty = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                charactersA.offer(s.charAt(i));
            }
            charactersA.offer(endPoint);
            boolean end = false;
            Character cur = null;
            while (true) {
                Character next = charactersA.poll();
                if (next == endPoint) {
                    if (!end) {
                        break;
                    }
                    Queue<Character> tem = charactersA;
                    charactersA = charactersEmpty;
                    charactersEmpty = tem;
                    if (cur != null) {
                        charactersA.add(cur);
                    }
                    charactersA.add(endPoint);
                    end = false;
                    cur = null;
                    continue;
                }
                boolean e = Objects.equals(cur, next);
                if (e) {
                    end = true;
                    cur = null;
                    continue;
                }
                if (cur != null) {
                    charactersEmpty.add(cur);
                }
                cur = next;
            }
            if (charactersEmpty.size() != 0) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }

        }
    }

}
