package com.wezhyn.learn.string;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000
 * <p>
 * Input: “babad"
 * Output: bab or aba
 * <p>
 * 回文具有天然的dp特性
 * 使用dp(i,j) 表示 string[i:j] 中的字符串 dp(i,j) =true 则 dp(i,j) 为str[i:j]为回文字符串
 * 则 dp(i,j) 只跟 dp(i+1,j-1) 有关
 * dp(i,j) = dp(i+1,j-1) && str[i]==str[j]
 *
 * @author wezhyn
 * @since 08.27.2020
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0;
        int len = 0;
        for (int step = 0; step <= s.length() - 1; step++) {
            for (int i = 0; i < s.length() - step; i++) {
                int j = i + step;
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    final boolean eq = s.charAt(i) == s.charAt(j);
                    if (i + 1 == j) {
                        dp[i][j] = eq;
                    } else {
                        dp[i][j] = eq && dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && (j - i + 1) > len) {
                    start = i;
                    len = j - i + 1;
                }
            }
        }
        return s.substring(start, start + len);
    }
}
