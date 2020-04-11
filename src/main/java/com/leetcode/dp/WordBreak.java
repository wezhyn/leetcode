package com.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * DP2: 输入是O(n)
 * dp(x) 依赖于所有可能的解
 * https://leetcode.com/problems/word-break/
 * 单词划分问题：将给定的字符串，划分成给定字典中的单词，
 * 举例：给定s: leetcode , 字典 leet code ,返回true
 * 补充：给定字符s 能被分割成重复字典中的单词，例如 leetcodeleet
 * <p>
 * 与 DP1 的不同在于，这个求解是依赖于所有的可能的子解
 * 帮助理解了 递归与dp
 * 与 DP1 不同在于没有明确的状态值和状态转移方程，主要使用的是DP 的本质思想：递归+记忆
 * <p>
 * 输入字符为 s
 * 先检查s[0,k]是否在字典中，再递归检查 [k+1,s.length] 是否在字典中，保存子解
 *
 * f(x) 为 str[0-i] && dict.contain(key)
 *
 * @author wezhyn
 * @since 03.16.2020
 */
public class WordBreak {

    private HashMap<String, Boolean> cache=new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("catsanddog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length()==0) {
            return true;
        }
        if (cache.get(s)!=null) {
            return cache.get(s);
        }
        boolean result=false;
        for (int i=0; i <= s.length(); i++) {
            String pre=s.substring(0, i);
            String sub=s.substring(i);
            final Boolean isResolved=cache.get(s);
            if (isResolved!=null) {
                return isResolved;
            } else {
                result=result || wordDict.contains(pre) && wordBreak(sub, wordDict);
            }
        }
        if (!result) {
            cache.put(s, false);
        }
        return result;
    }



}
