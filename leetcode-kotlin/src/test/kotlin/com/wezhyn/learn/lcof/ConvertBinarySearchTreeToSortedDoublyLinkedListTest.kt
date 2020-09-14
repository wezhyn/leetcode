package com.wezhyn.learn.lcof


import com.wezhyn.learn.BinaryTreeNode
import com.wezhyn.learn.doubleNode
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.30.2020
 */
class ConvertBinarySearchTreeToSortedDoublyLinkedListTest {

    @Test
    fun convert() {
        val node = ConvertBinarySearchTreeToSortedDoublyLinkedList()
                .convert("10,6,14,4,8,12,16,1,3".doubleNode<BinaryTreeNode> { it.toInt() })
        printTreeNode(node)
    }

    private fun printTreeNode(_node: BinaryTreeNode?) {
        var node: BinaryTreeNode? = _node
        val sb = StringBuilder()
        while (node != null) {
            sb.append(node.`val`)
                    .append(",")
            node = node.right
        }
        println(sb)
    }
}