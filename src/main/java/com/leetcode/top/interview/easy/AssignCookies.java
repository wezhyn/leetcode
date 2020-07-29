package com.leetcode.top.interview.easy;

import java.util.Arrays;

/**
 * @author wezhyn
 * @since 04.01.2020
 */
public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
//        si 指向当前要分配地cookies
        int gi=0, si=0, gl=g.length, sl=s.length;
        while (gi < gl && si < sl) {
            int greed=g[gi];
            while (si < sl) {
                if (s[si] >= greed) {
                    si++;
                    gi++;
                    break;
                } else {
                    si++;
                }
            }
        }
        return gi;
    }

}
