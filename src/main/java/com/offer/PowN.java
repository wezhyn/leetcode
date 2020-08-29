package com.offer;

/**
 * 二分推导： x^n = x^{n/2} *  x^{n/2} = (x^2)^{n/2}x
 *
 * @author wezhyn
 * @since 08.29.2020
 */
public class PowN {
    public double myPow(double x, int _n) {
        if (x == 0) {
            return 0;
        }
        long n = _n;
        double res = 1.0;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        while (n > 0) {
//            当前 n 为奇数的情况下，使其变成偶数
            if ((n & 1) == 1) res *= x;
            x *= x;
            n >>= 1;
        }
        return res;
    }


}
