package com.baijiahulian;

/**
 * @author wezhyn
 * @since 08.07.2020
 */
public class ReverseParentheses {


    public String reverseParentheses(String s) {
        return reverse(s, 0, 0).string;
    }

    //    ith 代表当前是第几个括号
    private Pair reverse(String s, int l, int ith) {
        final StringBuilder sb = new StringBuilder();
        int i = l;
        String sub = "";
        while (i < s.length()) {
            final char cur = s.charAt(i);
            switch (cur) {
                case '(': {
                    sb.append('1');
                    Pair p = reverse(s, i + 1, ith + 1);
                    sub = p.string;
//                    讲当前i向前移动 子(xx) 长度
                    i += p.offset + 1;
                    break;
                }
                case ')': {
                    return handleSub(sb, sub, ith, i - l + 1);
                }
                default: {
                    sb.append(cur);
                    i++;
                }
            }
        }
        return handleSub(sb, sub, ith, i - l + 1);
    }

    private Pair handleSub(StringBuilder sb, String sub, int ith, int offset) {
//                  偶数不反转
        StringBuilder result = new StringBuilder();
        if (ith % 2 == 0) {
            for (int j = 0; j < sb.length(); j++) {
                final char c = sb.charAt(j);
                if (c == '1') {
                    result.append(sub);
                } else {
                    result.append(c);
                }
            }
        } else {
//                  奇数反转
            for (int j = sb.length() - 1; j >= 0; j--) {
                final char c = sb.charAt(j);
                if (c == '1') {
                    result.append(sub);
                } else {
                    result.append(c);
                }
            }
        }
        return new Pair(result.toString(), offset);

    }

    private static class Pair {
        String string;
        int offset;

        public Pair(String string, int offset) {
            this.string = string;
            this.offset = offset;
        }
    }
}
