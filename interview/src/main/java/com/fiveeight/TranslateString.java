package com.fiveeight;

/**
 * @author wezhyn
 * @since 08.31.2020
 */
public class TranslateString {
    /**
     * 使用 dp(i) 表示截至 num[0:i] 当前数组能被翻译的最大可能数量
     * dp(i) = dp(i-1) + arr[i-1:i]*dp(i-2)
     * <p>
     * 翻译组合数
     *
     * @param num int整型 数字加密报文
     * @return int整型
     */
    public int translateNum(int num) {
        // write code here
        if (num < 0) {
            return 0;
        }
        String numStr = String.valueOf(num);
        int[] dp = new int[numStr.length() + 2];
        dp[1] = 1;
        for (int i = 0; i < numStr.length(); i++) {
            char cur = numStr.charAt(i);

            boolean doubleNum = i == 0;
            if (i > 0) {
                char pre = numStr.charAt(i - 1);
                int dNum = (pre - '0') * 10 + (cur - '0');
                if (dNum >= 10 && dNum <= 25) {
                    doubleNum = true;
                }
            }

            dp[i + 2] = dp[i + 1] + (doubleNum ? dp[i] : 0);
        }
        return dp[numStr.length() + 1];
    }
}
