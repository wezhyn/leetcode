package com.leetcode.top.interview.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wezhyn
 * @since 04.04.2020
 */
public class CountAndSay {

    @Test
    public void test() {
        Assert.assertEquals("311311222113111231131112132112311321322112111312211312111322212311322113212221",countAndSay(15));
        Assert.assertEquals("111221",countAndSay(5));
        Assert.assertEquals("1211",countAndSay(4));
        Assert.assertEquals("21",countAndSay(3));
        Assert.assertEquals("1", countAndSay(1));
        Assert.assertEquals("11", countAndSay(2));
    }

    public String countAndSay(int n) {
        String say="1";
        for (int i=2; i <= n; i++) {
            say=say(say);
        }
        return say;
    }

    private String say(String s) {
        StringBuilder sb=new StringBuilder();
        int count=1;
        char pre=s.charAt(0);
        for (int i=1; i < s.length(); i++) {
            if (s.charAt(i)==pre) {
                count++;
            } else {
                sb.append(count).append(pre);
                count=1;
                pre=s.charAt(i);
            }
        }
        sb.append(count).append(pre);
        return sb.toString();
    }
}
