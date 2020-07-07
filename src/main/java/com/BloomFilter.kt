package com

import java.util.*

/**
 * BloomFilter 即 无冲突解决的HashMap ，若 BloomFilter 返回不存在，则一定不存在，若BloomFilter 返回存在，可能不存在也可能存在【冲突Key】
 * 但 BloomFilter 实现了多个hash 函数
 * 1. 计算 key.hashCode()
 * 2. 将对应的 数组位置设置为 1
 * @author wezhyn
 * @since 07.07.2020
 *
 */
class BloomFilter(private val bitSize: Int) {

    private val bitSet = BitSet(2.shl(bitSize))

    private companion object BloomFilterHash {
        val seeds = intArrayOf(7, 113, 3213, 2111, 397, 711, 937)

        fun seedFun(value: String, seed: Int, bitSize: Int): Int {
            var result = 0
            for (v in value) {
                result = seed * result + v.toInt()
            }
            return (2.shl(bitSize) - 1).and(result)
        }
    }

    fun add(value: String) {
        for (v in seeds) {
            bitSet.set(seedFun(value, v, bitSize))
        }
    }

    fun container(value: String): Boolean {
        for (v in seeds) {
            if (!bitSet.get(seedFun(value, v, bitSize))) {
                return false
            }
        }
        return true
    }

}