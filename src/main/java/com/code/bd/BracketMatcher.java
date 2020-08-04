package com.code.bd;

import java.util.Scanner;
import java.util.Stack;


/**
 * @author wezhyn
 * @since 08.02.2020
 */
public class BracketMatcher {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String str = in.nextLine();
            Stack<Character> characters = new Stack<>();
            final StringBuilder preBracket = new StringBuilder();
            final StringBuilder aftBracket = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char cur = str.charAt(i);
                if (cur == ']') {
                    if (characters.isEmpty()) {
                        preBracket.append('[');
                    } else {
                        characters.pop();
                    }
                } else {
                    characters.push(cur);
                }
            }
            for (int i = 0; i < characters.size(); i++) {
                aftBracket.append(']');
            }
            System.out.println(preBracket + str + aftBracket);
        }
    }

}
