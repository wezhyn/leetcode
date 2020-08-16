package com.code.tiger;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * @author wezhyn
 * @since 08.16.2020
 */
public class FrequencyCharacter {
    public String frequencySort(String str) {
        Map<Character, Integer> nums = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            final char c = str.charAt(i);
            final Integer preNum = nums.getOrDefault(c, 0);
            nums.put(c, preNum + 1);
        }
        final TreeMap<Character, Integer> treeMap = new TreeMap<>(nums);
        final StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : treeMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }

}
