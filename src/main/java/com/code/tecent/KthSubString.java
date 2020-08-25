package com.code.tecent;

import java.util.*;

/**
 * @author wezhyn
 * @since 08.23.2020
 */
public class KthSubString {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String str = in.nextLine();
            int k = in.nextInt();
            Map<Character, List<Integer>> cIndexs = new HashMap<>(32);
            for (int i = 0; i < str.length(); i++) {
                final char c = str.charAt(i);
                List<Integer> list = cIndexs.computeIfAbsent(c, k1 -> new ArrayList<>());
                list.add(i);
            }
            TreeSet<String> strings = new TreeSet<>();
            for (int i = 0; i < 26; i++) {
                char c = (char) ('a' + i);
                strings.clear();
                final int totalNum = charNum(str, cIndexs.get(c), strings, k);
                if (totalNum >= k) {
                    System.out.println(strings.pollLast());
                    return;
                } else {
                    k -= strings.size();
                }
            }
        }
    }

    private static int charNum(String str, List<Integer> indexs, TreeSet<String> strings, int k) {
        int num = 0;
        for (int i : indexs) {
            for (int j = i; j < str.length(); j++) {
                strings.add(str.substring(i, j + 1));
                if (strings.size() > k) {
                    strings.pollLast();
                }
                num++;
            }
        }
        return num;
    }
}
