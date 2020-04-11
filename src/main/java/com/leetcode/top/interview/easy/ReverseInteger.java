package com.leetcode.top.interview.easy;

/**
 * @author wezhyn
 * @since 03.31.2020
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(Integer.MAX_VALUE));
        System.out.println(Integer.MIN_VALUE + 1);
    }

    public int reverse(int x) {
        int rev=0;
        while (x!=0) {
            int remain=x%10;
            x/=10;
//            MAX_VALUE: 2,147,483,647 ,当 rev=2,147,483,640时， +8就会溢出
            if (rev > Integer.MAX_VALUE/10 || (rev==Integer.MAX_VALUE/10 && remain > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev==Integer.MIN_VALUE/10 && remain < -8)) return 0;
            rev=10*rev + remain;
        }
        return rev;
    }


}
