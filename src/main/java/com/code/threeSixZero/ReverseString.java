package com.code.threeSixZero;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * @author wezhyn
 * @since 08.24.2020
 */
public class ReverseString {

    private static final Set<Character> SYMMETRIC_CHAR = new HashSet<>();

    static {
        SYMMETRIC_CHAR.add('A');
        SYMMETRIC_CHAR.add('H');
        SYMMETRIC_CHAR.add('I');
        SYMMETRIC_CHAR.add('W');
        SYMMETRIC_CHAR.add('T');
        SYMMETRIC_CHAR.add('Y');
        SYMMETRIC_CHAR.add('U');
        SYMMETRIC_CHAR.add('O');
        SYMMETRIC_CHAR.add('X');
        SYMMETRIC_CHAR.add('V');
        SYMMETRIC_CHAR.add('N');
        SYMMETRIC_CHAR.add('M');
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                String line = in.nextLine();
                String reverse = reverseString(line);
                if (line.length() == reverse.length() && line.equals(reverse)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static String reverseString(String line) {
        StringBuilder sb = new StringBuilder();
        for (int i = line.length() - 1; i >= 0; i--) {
            final char c = line.charAt(i);
            if (SYMMETRIC_CHAR.contains(c)) {
                sb.append(c);
            } else {
                break;
            }
        }
        return sb.toString();
    }

}
