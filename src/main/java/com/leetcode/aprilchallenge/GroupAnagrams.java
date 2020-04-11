package com.leetcode.aprilchallenge;

import java.util.*;

/**
 * @author wezhyn
 * @since 04.06.2020
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map=new HashMap<>();
        for (String str : strs) {
            char[] cTemp=str.toCharArray();
            Arrays.sort(cTemp);
            String temp=new String(cTemp);
            map.putIfAbsent(temp, new ArrayList<>());
            map.get(temp).add(str);
        }
        return new ArrayList<>(map.values());
    }


}
