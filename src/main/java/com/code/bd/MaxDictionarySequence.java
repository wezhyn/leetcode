package com.code.bd;

import java.util.Scanner;


/**
 * 字典序最大，代表 str[0] 就一定要大于等于其它
 * 从后向前扫描，则 str[0] 为最后最大的元素
 *
 * @author wezhyn
 * @since 08.02.2020
 */
public class MaxDictionarySequence {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String str = in.nextLine();
            final StringBuilder sb = new StringBuilder();
            final int strIndex = str.length() - 1;
            char preChar = str.charAt(strIndex);
            sb.insert(0, preChar);
            for (int i = strIndex - 1; i >= 0; i--) {
                if (Character.isAlphabetic(str.charAt(i)) && str.charAt(i) >= preChar) {
                    sb.insert(0, str.charAt(i));
                    preChar = str.charAt(i);
                }
            }
            System.out.println(sb);
        }
    }

}
