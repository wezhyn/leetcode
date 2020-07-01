package com.offer

import com.BinaryTreeNode
import com.IntDoubleNode

/**
 * 将一个搜索二叉树转变成一个双向链表，只允许修改原节点中的指针
 *
 * 转变后的双向链表即原搜索二叉树的中序遍历，故而使用递归的方法进行求解
 *
 * 为了使得一棵子树在递归结束后以一个节点看待，抽象一个 CombinationNode,将返回的子树中的最左和最右作为两端，
 * 返回当前抽象的节点进行操作
 *
 *
 * @author wezhyn
 * @since 06.30.2020
 *
 */
class ConvertBinarySearchTreeToSortedDoublyLinkedList {

    fun convert(root: BinaryTreeNode?): BinaryTreeNode? {
        if (root == null) {
            return null
        }
        val combination = combination(root)
        return combination.left
    }

    private fun combination(root: BinaryTreeNode): CombinationNode {
//        left 指向小 right 指向大
        val leftNode = root.left?.let { combination(it) }
        val rightNode = root.right?.let { combination(it) }
        leftNode?.right = root
        root.left = leftNode?.right
        rightNode?.left = root
        root.right = rightNode?.left
        return CombinationNode(leftNode?.left ?: root, rightNode?.right ?: root)

    }


    class CombinationNode(private val _left: BinaryTreeNode, private val _right: BinaryTreeNode) : IntDoubleNode<BinaryTreeNode> {

        override var left: BinaryTreeNode?
            get() = _left
            set(value) {
                _left.left = value
            }
        override var right: BinaryTreeNode?
            get() = _right
            set(value) {
                _right.right = value
            }
    }


}