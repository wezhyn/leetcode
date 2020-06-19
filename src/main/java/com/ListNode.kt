package com

/**
 *
 * @author wezhyn
 * @since 06.14.2020
 *
 */
fun createListNodes(vararg numbers: Int): ListNode? {
    val head = ListNode(-1)
    var cur = head
    for (number in numbers) {
        cur.next = ListNode(number)
        cur = cur.next!!
    }
    return head.next
}

fun ListNode.print() {
    val sb = StringBuilder()
    var cur: ListNode? = this
    while (cur != null) {
        sb.append(cur.`val`)
        sb.append(",")
        cur = cur.next
    }
    sb.append("null")
    println(sb.toString())
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    constructor(`val`: Int, next: ListNode?) : this(`val`) {
        this.next = next
    }

}