package com.leetcode.top.interview;

/**
 * 回文： aasabas, 其中 aa ,sabas 都是回文
 * 一个回文是围绕其中心进行对称的，大致分成下面两类： aa ,aba
 * aa以中间空白进行堆成，aba 以 b 进行对称, 对应有 2*len -1 ,减去开头前或结尾后的一个空格
 * 故而对应https://leetcode.com/problems/longest-palindromic-substring/solution Approach 4: Expand Around Center
 *
 * @author wezhyn
 * @since 03.14.2020
 */
public class LongestPalindromicSubstringSimple {

    public static void main(String[] args) {
        final String s=longestPalindrome("cadabbd");
        System.out.println(s);
    }

    public static String longestPalindrome(String s) {
        int len=0;
        int start=0;
        for (int i=0; i < s.length(); i++) {
            int cur=Math.max(maxPalindrome(s, i, i), maxPalindrome(s, i, i + 1));
            if (cur > len) {
                start=i - (cur - 1)/2;
                len=cur;
            }
        }
        return s.substring(start, len+start);
    }

    public static int maxPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l)==s.charAt(r)) {
            --l;
            ++r;
        }
        return r - l - 1;
    }
}
