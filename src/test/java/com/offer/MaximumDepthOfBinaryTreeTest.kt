package com.offer

import com.treeNodeWithNull
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.18.2020
 */
class MaximumDepthOfBinaryTreeTest {

    @Test
    fun maxDepth() {
        assertEquals(-1, MaximumDepthOfBinaryTree().maxDepth(
                "null".treeNodeWithNull { it.toInt() }
        ))
        assertEquals(1, MaximumDepthOfBinaryTree().maxDepth(
                "1".treeNodeWithNull { it.toInt() }
        ))
        assertEquals(2, MaximumDepthOfBinaryTree().maxDepth(
                "1,2,null".treeNodeWithNull { it.toInt() }
        ))
        assertEquals(4, MaximumDepthOfBinaryTree().maxDepth(
                "1,2,3,4,5,null,6,null,null,7,null".treeNodeWithNull { it.toInt() }
        ))
        assertEquals(3, MaximumDepthOfBinaryTree().maxDepth(
                "3,9,20,null,null,15,7".treeNodeWithNull { it.toInt() }
        ))
    }
}