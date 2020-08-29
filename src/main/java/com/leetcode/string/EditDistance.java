package com.leetcode.string;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * <p>
 * 案例中 horse 经过一步有如下结果：
 * 1. 插入一个字符：1+ xhorse -> 1+ horse：ros
 * 2. 删除一个字符：1+ orse: ros
 * 3. 替换一个字符：1+ xorse -> 1+ orse: ros
 * 4. h==r 假设匹配：0 + orse:ros
 * <p>
 * 所以一个大问题可以拆分成小问题，即一个状态依赖于子状态
 * 所以要从小字符串 orse -> 推出 horse ，即从 字符串尾部开始
 * 使用dp(i,j) 表示 word1[i:] 与 word2[j:] 的最少匹配次数
 * <p>
 * dp(i,j) = Min(1+Min( dp(i,j+1),dp(i+1,j),dp(i+1,j+1)) | dp[i+1,j+1])
 *
 * @author wezhyn
 * @since 08.29.2020
 */
public class EditDistance {


    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int j = word2.length(); j >= 0; j--) {
            dp[word1.length()][j] = word2.length() - j;
        }
        for (int i = word1.length(); i >= 0; i--) {
            dp[i][word2.length()] = word1.length() - i;
        }
        for (int i = word1.length() - 1; i >= 0; i--) {
            for (int j = word2.length() - 1; j >= 0; j--) {
                int ci = word1.charAt(i), cj = word2.charAt(j);
                dp[i][j] = Math.min(
                        1 + Math.min(dp[i][j + 1], dp[i + 1][j]),
                        (ci == cj ? 0 : 1) + dp[i + 1][j + 1]
                );
            }
        }
        return dp[0][0];
    }

}
