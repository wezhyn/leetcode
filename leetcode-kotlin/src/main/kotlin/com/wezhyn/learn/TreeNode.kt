package com.wezhyn.learn

import java.util.*

/**
 *
 * @author wezhyn
 * @since 06.15.2020
 *
 */
class TreeNode(val `val`: Int) {

    var left: TreeNode? = null
    var right: TreeNode? = null

    companion object {


        fun traverseBfsWithNull(node: TreeNode?) {
            if (node == null) {
                return
            }
            val queue: Queue<TreeNode> = LinkedList()
            val nullPoint = TreeNode(Int.MIN_VALUE)
            val generationPoint = TreeNode(-1)
            queue.offer(node)
            queue.offer(generationPoint)
            var isEnd = true
            var next: TreeNode
            val sb = StringBuilder()
            while (queue.poll().also { next = it } != null) {
                if (next === nullPoint) {
                    sb.append("null,")
                    queue.offer(nullPoint)
                    queue.offer(nullPoint)
                } else if (next === generationPoint) {
                    if (isEnd) {
                        break
                    } else {
                        isEnd = true
                        queue.offer(generationPoint)
                    }
                } else {
                    sb.append(next.`val`).append(",")
                    if (next.left == null) {
                        queue.offer(nullPoint)
                    } else {
                        isEnd = false
                        queue.offer(next.left)
                    }
                    if (next.right == null) {
                        queue.offer(nullPoint)
                    } else {
                        isEnd = false
                        queue.offer(next.right)
                    }
                }
            }
            println(sb.toString())
        }

    }
}