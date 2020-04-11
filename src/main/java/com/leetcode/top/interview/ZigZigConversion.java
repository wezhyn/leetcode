package com.leetcode.top.interview;

/**
 * 分析ZigZig规律，y: 当前行所要的第几个字符串，x : 当前列所在的位置(从0开始)
 * 当 x=0 时， F(y,x,n)=(2y+2y%2)(n-x-1)
 * 当 x>0 && x< n-1 时，F(y,x,n)=(y+1-y%2)x+(y+y%2)(n-x-1)
 * 当x=n-1时，F(y,x,n)=(2y+1-2y%2)x
 * 由于 当x=0||x=n-1时，对于原先的规律(>0||<n-1),导致 0列==1列,2列==3列所在原位置，故而对于此列，第0列未0，第1列未2
 *
 * @author wezhyn
 * @since 03.31.2020
 */
public class ZigZigConversion {

    public static void main(String[] args) {
        System.out.println(new ZigZigConversion().convert("PAYPALISHIRING",4));
    }

    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int len=s.length();
        StringBuilder sb=new StringBuilder();
        for (int x=0; x < numRows; x++) {
            for (int y=0; y < len; y++) {
                int by;
                if (x==0 || x==numRows - 1) {
                    by=2*y;
                } else {
                    by=y;
                }
                int charAtStr=(by + 1 - by%2)*x + (by + by%2)*(numRows - 1 - x);
                if (charAtStr >= len) {
                    break;
                }
                sb.append(s.charAt(charAtStr));
            }
        }
        return sb.toString();
    }

}
