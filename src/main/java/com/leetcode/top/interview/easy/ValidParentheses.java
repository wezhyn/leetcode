package com.leetcode.top.interview.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * 根据前天写的SingleNumber，对于这道题，尝试使用异或解决
 * <p>
 * 1^2 = 3
 * 3^4 = 7
 * 所以每一个不同的符号，采用 2^n次方表示
 *
 * @author wezhyn
 * @since 04.03.2020
 */
public class ValidParentheses {

    @Test
    public void test() {
        Assert.assertFalse(isValid("(([]){}))"));
        Assert.assertTrue(isValid("(([]){})"));
        Assert.assertFalse(isValid("((([]){})"));
        Assert.assertTrue(isValid("()[]{}"));
        Assert.assertFalse(isValid("(]"));
        Assert.assertFalse(isValid("([)]"));
        Assert.assertTrue(isValid("{[]}"));
    }

    public boolean isValid(String s) {
        Stack<Integer> sequences=new Stack<>();
        sequences.push(0);
        for (int i=0; i < s.length(); i++) {
            final Integer peek=sequences.peek();
            Integer cur=bracket(s.charAt(i));
            if (cur + peek==0) {
                sequences.pop();
            } else {
                sequences.push(cur);
                if (cur < 0) {
                    break;
                }
            }
        }
        return sequences.peek()==0;
    }

    private int bracket(char c) {
        switch (c) {
            case '(':
                return 1;
            case ')':
                return -1;
            case '[':
                return 2;
            case ']':
                return -2;
            case '{':
                return 4;
            case '}':
                return -4;
            default:
                return 0;
        }
    }
}
