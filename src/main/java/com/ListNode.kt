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

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is ListNode) {
            return false
        }
        val o = other as ListNode
        if (this.`val` == o.`val`) {
            if (this.next == null && o.next == null) {
                return true
            }
            return this.next?.equals(o.next) ?: false
        }
        return false
    }

    override fun hashCode(): Int {
        var result = `val`
        result = 31 * result + (next?.hashCode() ?: 0)
        return result
    }
}