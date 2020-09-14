package com.wezhyn.learn

import java.util.*

/**
 *
 * @author wezhyn
 * @since 06.22.2020
 *
 */
inline fun <reified R : IntDoubleNode<R>> String.doubleNode(delimiters: String = ",", convert: (String) -> Int = { it.trim().toInt() }): R? {
    val values = this.split(delimiters)
    if (values.isEmpty()) {
        return null
    }
    val head = createNode<R>(convert.invoke(values[0]))
    val queue = LinkedList<R>().apply { offer(head) }
    for (v in 1 until values.size step 2) {
        val poll = queue.poll()
        poll.left = createNode(convert.invoke(values[v]))
        poll.right = createNode(convert.invoke(values[v + 1]))
        poll.left?.let { queue.offer(it) }
        poll.right?.let { queue.offer(it) }
    }
    return head
}

inline fun <reified R : SingleNode<R>> String.oneSingleNode(delimiters: String = ",", convert: (String) -> Int = { it.trim().toInt() }): R? {
    val values = this.split(delimiters)
    if (values.isEmpty()) {
        return null
    }
    val head = createNode<R>(-1)
    var cur = head
    for (v in values) {
        cur.next = createNode(convert.invoke(v))
        cur = cur.next!!
    }
    return head.next!!
}

inline fun <reified R> createNode(v: Int): R {
    val klass = R::class.java
    val constructor = klass.getDeclaredConstructor(Int::class.java)
    return constructor.newInstance(v)
}