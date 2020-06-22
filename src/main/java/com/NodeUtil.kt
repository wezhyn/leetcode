package com

/**
 *
 * @author wezhyn
 * @since 06.22.2020
 *
 */

fun String.oneListNode(delimiters: String = ",", convert: (String) -> Int = { it.trim().toInt() }): ListNode? {
    val values = this.split(delimiters)
    if (values.isEmpty()) {
        return null
    }
    val head = ListNode(-1)
    var cur = head
    for (v in values) {
        cur.next = ListNode(convert.invoke(v))
        cur = cur.next!!
    }
    return head.next
}