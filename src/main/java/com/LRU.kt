package com

/**
 * O(1) 时间内将 Linked 表中对应元素移动到最后
 * O(1) 时间内将元素插入
 * 模拟 LinkedHashMap
 * @author wezhyn
 * @since 08.09.2020
 *
 */
class LRUCache(private val capacity: Int) {

    private val cache = HashMap<Int, Node>()
    private var count = 0
    private val head = Node(-1, -1)
    private var tail: Node? = head

    fun get(key: Int): Int {
        return cache[key]?.let {
            move(it)
            addLast(it)
            return it.value
        } ?: -1
    }

    fun put(key: Int, value: Int) {
        if (capacity == 0) {
            return
        }
        val n = Node(key, value)
        val absent = cache.putIfAbsent(key, n)
        if (absent == null) {
            count++
            addLast(n)
        } else {
            move(absent)
            absent.value = value
            addLast(absent)
        }
        if (count > capacity) {
            head.next?.let {
                move(it)
                cache.remove(it.key)
            }
            count--
        }
    }

    private fun move(it: Node) {
        val pre = it.pre
        val next = it.next
        pre?.next = next
        next?.pre = pre
        if (tail == it) {
            tail = it.pre
        }
    }


    private fun addLast(n: Node) {
        n.pre = tail ?: head
        n.next = tail?.next
        n.pre?.next = n
        tail = n

    }


    private class Node(val key: Int, var value: Int) {
        var pre: Node? = null
        var next: Node? = null
    }

}