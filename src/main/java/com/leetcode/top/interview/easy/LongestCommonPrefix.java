package com.leetcode.top.interview.easy;

/**
 * 原想法是最菜的一种，现在采用分而治之+缓存
 *
 * @author wezhyn
 * @since 04.02.2020
 */
public class LongestCommonPrefix {




    public String longestCommonPrefix(String[] strs) {
        if (strs.length==1) {
            return strs[0];
        }
        String maxCom="";
        int maxLen=Integer.MAX_VALUE;
        for (int sep=1; sep < strs.length; sep+=sep) {
            for (int i=0; i + sep < strs.length; i+=2*sep) {
                String cur=strs[i];
                String next=strs[i + sep];
                final String prefix=commonPrefix(cur, next, maxLen);
                if (prefix.length() < maxLen) {
                    maxCom=prefix;
                    maxLen=prefix.length();
                }
            }
        }
        return maxCom;
    }

    public String commonPrefix(String one, String ano, int maxLen) {
        int len=Math.min(
                Math.min(ano.length() - 1, one.length() - 1),
                maxLen
        );
        int i;
        for (i=0; i <= len; i++) {
            if (one.charAt(i)!=ano.charAt(i)) {
                return one.substring(0, i);
            }
        }
        return ano.substring(0, i);
    }
}
