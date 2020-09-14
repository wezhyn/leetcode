package com.wezhyn.learn.lcof


import com.wezhyn.learn.TreeNode
import com.wezhyn.learn.onePrimitiveArray
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.26.2020
 */
class ConstructBinaryTreeTest {

    @Test
    fun buildTree() {
        val buildTree = ConstructBinaryTree().buildTree("3,9,20,15,7".onePrimitiveArray { it.toInt() }, "9,3,15,20,7".onePrimitiveArray { it.toInt() })
        TreeNode.traverseBfsWithNull(buildTree)
    }
}