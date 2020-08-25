package com.leetcode.dp.delete_one

/**
 * 使用 dp(k,f) 表示仍k个鸡蛋在 f 层最小步数
 *
 * 假设在第 fi 层扔下鸡蛋，则分如下两种情况：
 * 1. 鸡蛋碎了，则 dp(k,f)= 1 + dp(k-1)[fi]
 * 2. 鸡蛋没碎，则 dp(k,f)= 1+ dp(k)[fi-f]
 *
 * @author wezhyn
 * @since 08.24.2020
 *
 */
class SuperEggDrop {


}