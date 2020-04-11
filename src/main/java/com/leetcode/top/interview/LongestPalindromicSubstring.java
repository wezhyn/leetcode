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
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        final String s=longestPalindrome("cdbbd");
        System.out.println(s);
    }

    public static String longestPalindrome(String s) {

        int length=s.length();
        String max="";
//        1,2 指向第一个字符，即 1 第一个字符， 2第一个字符后的空格， 2*length ,当 i=2*n-1 时，代表其为字符串尾部
        for (int i=1; i <= 2*length - 1; i++) {
//            i: odd -> 字符 i: even -> 空格
            int offset=i%2==1 ? 0 : 1;
            int currentIndex=(i - 1)/2;
//            xIxx
//            xx xx
            int maxBound=Math.min(currentIndex + offset, length - 1 - currentIndex);
            int j;
            if (maxBound==0) {
                if (max.length()==0) {
                    max=s.substring(currentIndex + offset, currentIndex + offset + 1);
                }
                continue;
            }
            for (j=1; j <= maxBound; j++) {
                char leftChar=s.charAt(currentIndex + offset - j);
                char rightChar=s.charAt(currentIndex + j);
                if (leftChar!=rightChar || j==maxBound) {
                    j=leftChar==rightChar ? j + 1 : j;
                    int realLength=i%2==1 ? (j - 1)*2 + 1 : (j - 1)*2;
                    if (realLength > max.length()) {
                        max=s.substring(currentIndex + offset - j + 1, currentIndex + j);
                    }
                    break;
                }
            }
//            整合遗漏检查正常退出的情况
        }
        return max;
    }
}
