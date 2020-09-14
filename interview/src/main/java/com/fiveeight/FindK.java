package com.fiveeight;

/**
 * @author wezhyn
 * @since 08.31.2020
 */
public class FindK {
    /**
     * @param a int整型
     * @param b int整型
     * @return int整型
     */
    public int question(int a, int b) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int kk = i * i;
            int ka = kk - a;
            if (ka > 500) {
                break;
            } else if (ka < 0) {
                continue;
            }
            int kb = (int) Math.sqrt(ka + b);
            if (kb * kb == ka + b) {
                return ka;
            }
        }
        return -1;
    }
}
