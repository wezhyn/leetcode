package com.wezhyn.learn.lcof

import com.wezhyn.learn.TreeNode
import java.util.*

/**
 *
 * @author wezhyn
 * @since 07.18.2020
 *
 */
class MaximumDepthOfBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        val stack = Stack<TreeNode?>()
        var depth = 1
        var maxDepth = 0
        var cur: TreeNode? = root ?: return 0
//        使用一个特殊的节点，用于层级-1, 即如果一个节点既有左节点又有右节点，补上一个null节点，用于访问父亲节点的右节点
        val specialNode = TreeNode(-1)
        while (cur != null || stack.isNotEmpty()) {
//            添加直到当前节点最左节点的全部右节点
            while (cur != null) {
                depth++
                stack.push(cur.right)
                cur = cur.left
            }
//            最左节点的兄弟节点
            cur = stack.pop()
            if (cur === specialNode) {
                depth--
                continue
            }
            if (cur == null) {
//                无兄弟节点
                depth--
                maxDepth = Math.max(maxDepth, depth)
            } else {
                stack.push(specialNode)
            }
        }
        return maxDepth
    }

}