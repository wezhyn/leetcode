package com.wezhyn.learn.string;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同
 * Input: "leetcode"
 * Output: false
 * <p>
 * 要求不使用额外的数据结构
 * <p>
 * 当使用额外数据结构时，通常会使用 BitSet 来进行对应位索引的判断 即 BitSet.get() BitSet.set()
 * 如果不适用额外的数据结构，使用几个 long 来模拟这个操作，即位运算
 *
 * @author wezhyn
 * @since 08.29.2020
 */
public class IsUniqueLcci {
    public boolean isUnique(String astr) {
        long slow = 0, high = 0;
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            final int tIndex = 1 << ((c <= 63 ? 64 : 128) - c);
            if (c <= 63) {
                if ((slow & tIndex) != 0) {
                    return false;
                }
                slow ^= tIndex;
            } else {
                if ((high & tIndex) != 0) {
                    return false;
                }
                high ^= tIndex;
            }
        }
        return true;
    }
}
