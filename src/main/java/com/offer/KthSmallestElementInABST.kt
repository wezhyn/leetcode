package com.offer

import com.TreeNode
import java.util.*

/**
 *
 * 使用中序遍历进行查找，当访问第K的元素时，即为第K大的元素
 * @author wezhyn
 * @since 07.18.2020
 *
 */
class KthSmallestElementInABST {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        var count = 0
        var cur = root
        val queue = Stack<TreeNode>()
        while (cur != null || queue.isNotEmpty()) {
//            将当前节点的左节点全部入栈
//            cur==null 代表上一个循环最左端节点无右节点
            while (cur != null) {
                queue.push(cur)
                cur = cur.left
            }
//            之前节点的最左节点
            cur = queue.pop()
            if (++count == k) {
                return cur.`val`
            }
            cur = cur.right
        }
        return -1
    }
}