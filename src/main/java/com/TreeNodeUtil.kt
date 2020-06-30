package com

import java.util.*

/**
 *
 * @author wezhyn
 * @since 06.30.2020
 *
 */

fun String.treeNodeWithNull(segmentation: String = ",",
                            convert: (String) -> Int): TreeNode? {

    val nums = this.split(segmentation)
    val c = { s: String ->
        if (s.trim() == "null") {
            null
        } else {
            TreeNode(convert.invoke(s.trim()))
        }
    }
    val root = c(nums[0]) ?: return null
    val queue = LinkedList<TreeNode>().apply { offer(root) }
    for (one in 1 until nums.size step 2) {
        val pop = queue.poll()
        pop.left = c(nums[one]).apply { queue.offer(this) }
        pop.right = c(nums[one + 1]).apply { queue.offer(this) }

    }
    return root

}