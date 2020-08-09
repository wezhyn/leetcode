package com

import org.junit.Test
import kotlin.test.assertEquals

/**
 *
 * @author wezhyn
 * @since 08.09.2020
 */
class LRUCacheTest {

    @Test
    fun get() {
        val cache = LRUCache(2 /* capacity */)
        cache.put(1, 1)
        cache.put(2, 2)
        assertEquals(1, cache.get(1)) // returns 1
        cache.put(3, 3) // evicts key 2
        assertEquals(-1, cache.get(2)) // returns -1 (not found)
        cache.put(4, 4) // evicts key 1
        assertEquals(-1, cache.get(1)) // returns -1 (not found)
        assertEquals(3, cache.get(3)) // returns 3
        assertEquals(4, cache.get(4)) // returns 4

    }

    @Test
    fun get3() {
        val cache = LRUCache(2 /* capacity */)
        cache.put(1, 1)
        cache.put(2, 2)
        assertEquals(1, cache.get(1)) // returns 1
        cache.put(2, 3) // evicts key 2
        assertEquals(3, cache.get(2)) // returns -1 (not found)
        cache.put(4, 4) // evicts key 1
        assertEquals(-1, cache.get(1)) // returns -1 (not found)
        assertEquals(-1, cache.get(3)) // returns 3
        assertEquals(4, cache.get(4)) // returns 4

    }

    @Test
    fun get2() {
        val cache = LRUCache(4 /* capacity */)
        cache.put(1, 1)
        cache.put(2, 2)
        assertEquals(1, cache.get(1)) // returns 1
        cache.put(3, 3) // evicts key 2
        assertEquals(2, cache.get(2)) // returns -1 (not found)
        cache.put(4, 4) // evicts key 1
        assertEquals(1, cache.get(1)) // returns -1 (not found)
        assertEquals(3, cache.get(3)) // returns 3
        assertEquals(4, cache.get(4)) // returns 4

    }

    @Test
    fun get1() {
        val cache = LRUCache(0 /* capacity */)
        cache.put(1, 1)
        cache.put(2, 2)
        assertEquals(-1, cache.get(1)) // returns 1
        cache.put(3, 3) // evicts key 2
        assertEquals(-1, cache.get(2)) // returns -1 (not found)
        cache.put(4, 4) // evicts key 1
        assertEquals(-1, cache.get(1)) // returns -1 (not found)
        assertEquals(-1, cache.get(3)) // returns 3
        assertEquals(-1, cache.get(4)) // returns 4

    }
}