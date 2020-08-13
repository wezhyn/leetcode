package com.code.bilibili;

import java.util.Stack;

/**
 * @author wezhyn
 * @since 08.13.2020
 */
public class BracketMatching {
    public boolean IsValidExp(String s) {
        Stack<Character> lefts = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (isLeft(cur)) {
                lefts.push(cur);
            } else {
                if (lefts.isEmpty()) {
                    return false;
                }
                char left = lefts.pop();
                if (!isEquals(left, cur)) {
                    return false;
                }
            }
        }
        return lefts.isEmpty();

    }

    private boolean isLeft(char c) {
        return c == '[' || c == '{' || c == '(';
    }

    private boolean isEquals(char left, char right) {
        if (left == '(' && right == ')') {
            return true;
        }
        if (left == '[' && right == ']') {
            return true;
        }
        if (left == '{' && right == '}') {
            return true;
        }
        return false;
    }
}
