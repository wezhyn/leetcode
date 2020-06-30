package com.offer

import com.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 *
 * @author wezhyn
 * @since 06.30.2020
 *
 */
class BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return emptyList()
        }
        val pill = TreeNode(-1)
        val queue = LinkedList<TreeNode>().apply {
            offer(pill)
            offer(root)
        }
        val result = ArrayList<ArrayList<Int>>()
        var curList = ArrayList<Int>()
        while (queue.isNotEmpty()) {
            val poll = queue.poll()
            if (poll === pill) {
                if (queue.isEmpty()) {
                    break
                }
                curList = ArrayList()
                result.add(curList)
                queue.add(pill)
            } else {
                curList.add(poll.`val`)
                poll.left?.let { queue.offer(it) }
                poll.right?.let { queue.offer(it) }
            }
        }
        return result
    }
}