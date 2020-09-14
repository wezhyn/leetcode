package com.zhongan;

/**
 * @author wezhyn
 * @since 08.29.2020
 */
public class LongestRepeatNum {
    /**
     * @param s string字符串
     * @return int整型
     */
    public int longestRepeatingSubstring(String s) {
        int max = 0, cur = 0;
        char r = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cur == 0) {
                cur++;
                r = c;
            } else if (c == r) {
                cur++;
            } else {
                cur = 1;
                r = c;
            }
            max = Math.max(max, cur);
        }
        return max == 1 ? 0 : max;
    }
}
