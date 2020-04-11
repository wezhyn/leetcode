package com.leetcode.top.interview.medium;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

/**
 * @author wezhyn
 * @since 04.07.2020
 */
public class LetterCombinationsOfAPhoneNumber {

    private List<String> result=new ArrayList<>();

    @Test
    public void test() {
//        System.out.println(letterCombinations("23"));
        System.out.println(dfsLetterCombinations("23"));
    }

    public List<String> dfsLetterCombinations(String digits) {
        if (digits==null || Objects.equals(digits, "")) {
            return Collections.emptyList();
        }
        char[] chars=new char[digits.length()];
        backtracking(chars, digits, 0);
        return result;
    }

    public void backtracking(char[] chars, String digits, int i) {
        if (digits.length()==i) {
            result.add(new String(chars));
            return;
        }
        final char[] digitsChars=digitsChars(digits.charAt(i));
        for (char c : digitsChars) {
            chars[i]=c;
            backtracking(chars, digits, i + 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length()==0 || Objects.equals(digits, "0") || Objects.equals(digits, "1")) {
            return Collections.emptyList();
        }
        Queue<Object> queue=new LinkedBlockingQueue<>();
        queue.offer("");
        queue.offer(0);
        for (int i=0; i < digits.length(); i++) {
            final char[] chars=digitsChars(digits.charAt(i));
            Object poll=queue.poll();
            while (!Objects.equals(poll, i)) {
                String s=(String) poll;
                for (char c : chars) {
                    queue.offer(s + c);
                }
                poll=queue.poll();
            }
            queue.offer(i + 1);
        }
        return queue.stream().filter(o->o instanceof String)
                .map(o->(String) o)
                .collect(Collectors.toList());
    }


    private char[] digitsChars(int i) {
        i=i - '0';
        switch (i) {
            case 1: {
                return new char[0];
            }
            case 7: {
                return createDigits('p', 's');
            }
            case 8: {
                return createDigits('t', 'v');
            }
            case 9: {
                return createDigits('w', 'z');
            }
        }
        int s=(i - 2)*3;
        return createDigits((char) ('a' + s), (char) ('a' + s + 2));
    }

    private char[] createDigits(char start, char end) {
        char[] chars=new char[end - start + 1];
        for (int i=start; i <= end; i++) {
            chars[i - start]=(char) i;
        }
        return chars;
    }
}
