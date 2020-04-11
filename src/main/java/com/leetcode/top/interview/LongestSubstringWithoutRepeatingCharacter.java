package com.leetcode.top.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口解决
 *
 * @author wezhyn
 * @since 03.11.2020
 */
public class LongestSubstringWithoutRepeatingCharacter {


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("ababs"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n=s.length(), ans=0;
        Map<Character, Integer> map=new HashMap<>();
//        [i,j]
        for (int i=0, j=0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
//                下一个索引
                i=Math.max(i, map.get(s.charAt(j)));
            }
            ans=Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j+1);
        }
        return ans;
    }
}
