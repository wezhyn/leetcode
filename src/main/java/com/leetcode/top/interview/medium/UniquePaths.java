package com.leetcode.top.interview.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * dp 依赖与之前有限个解
 * <p>
 * f(m,n)=f(m-1,n)+f(m,n-1)
 * m=0||n==0时，f(m,n)=1
 *
 * @author wezhyn
 * @since 04.12.2020
 */
public class UniquePaths {

    @Test
    public void test() {
        Assert.assertEquals(3, uniquePaths(3, 2));
        Assert.assertEquals(28, uniquePaths(7, 3));
        Assert.assertEquals(2000000000, uniquePaths(100, 100));
    }

    public int uniquePaths(int m, int n) {
        int[][] result=new int[m][n];
        for (int mi=1; mi < m; mi++) {
            for (int ni=1; ni < n; ni++) {
                result[mi][ni]=calculate(result, mi - 1, ni) + calculate(result, mi, ni - 1);
            }
        }
        int ans=calculate(result, m - 1, n - 1);
        return ans < 0 ? 2000000000 : ans;
    }

    public int calculate(int[][] result, int m, int n) {
        if (m==0 || n==0) {
            return 1;
        }
        return result[m][n];
    }

}
