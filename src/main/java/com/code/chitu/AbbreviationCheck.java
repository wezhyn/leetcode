package com.code.chitu;

/**
 * 给定⼀一个⾮非空字符串串 s 和⼀一个缩写 abbr，请校验它们是否匹配。
 * 假设字符串串中只包含⼩小写字⺟母，缩写中只包含⼩小写字⺟母和数字。
 * 缩写中的数字表示其缩略略的字符数；连续多位数字表示⼀一个多位数
 *
 * @author wezhyn
 * @since 08.07.2020
 */
public class AbbreviationCheck {

    /**
     * 使用双指针进行匹配
     *
     * @param word 匹配词
     * @param abbr 缩写
     * @return 是否符合
     */
    public boolean valid(String word, String abbr) {
//        指向下一个要匹配的位置
        int wI = 0;
        int aI = 0;
        while (wI < word.length() || aI < abbr.length()) {
            final Pair nextPair = next(abbr, aI);
            switch (nextPair.c) {
                case '*': {
                    aI += String.valueOf(nextPair.num).length();
                    wI += nextPair.num;
                    break;
                }
                default: {
                    if (word.charAt(wI) != abbr.charAt(aI)) {
                        return false;
                    } else {
                        wI++;
                        aI++;
                    }
                }
            }
        }
        return wI == word.length() && aI == abbr.length();
    }

    private Pair next(String abbr, int i) {
        int num = 0;
        if (Character.isAlphabetic(abbr.charAt(i))) {
//                a
            return new Pair(abbr.charAt(i), 1);
        } else {
//                12
            for (int j = i; j < abbr.length(); j++) {
                final char c = abbr.charAt(j);
                if (Character.isDigit(c)) {
                    num = num * 10 + c - '0';
                } else {
                    return new Pair('*', num);
                }
            }
        }
        return new Pair('*', num);
    }


    /**
     * 表示缩略词下一次匹配字符
     */
    private static class Pair {
        private char c;
        private int num;

        public Pair(char c, int num) {
            this.c = c;
            this.num = num;
        }
    }
}
