package com.leetcode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wezhyn
 * @since 04.11.2020
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        if (n==0) {
            return Collections.singletonList("");
        }
        List<String> result=new ArrayList<>();
        char[] middle=new char[2*n];
        middle[0]='(';
        dfs(result, middle, n - 1, n, n);
        return result;
    }

    private void dfs(List<String> result, char[] middle, int l, int r, int n) {
        int i=2*n - l - r;
        if (l > 0) {
            middle[i]='(';
            dfs(result, middle, l - 1, r, n);
        }
        if (r > 0 && r > l) {
            middle[i]=')';
            dfs(result, middle, l, r - 1, n);
        }
        if (r==0 && l==0) {
            result.add(new String(middle));
        }
    }
}
