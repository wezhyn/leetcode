package com.wezhyn.learn

import org.junit.Test

/**
 * @author wezhyn
 * @since 07.07.2020
 */
class BloomFilterTest {

    @Test
    fun add() {
        val bloomFilter = BloomFilter(20)
        var urls = arrayOf("www.example.com", "www.renren.com", "www.baidu.com", "www.baidu.com")
        for (u in urls) {
            bloomFilter.add(u)
        }
        for (u in urls) {
            println("$u exist? ${bloomFilter.container(u)}")
        }
        urls = arrayOf("www.example1.com", "www.renren1.com", "www.bai1du.com", "www.baidu.com")
        for (u in urls) {
            println("$u exist? ${bloomFilter.container(u)}")
        }
    }
}