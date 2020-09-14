package com.wezhyn.learn.lcof

import com.wezhyn.learn.TreeNode


/**
 *
 * @author wezhyn
 * @since 07.18.2020
 *
 */
class CheckAvlTree {
    fun isAvl(root: TreeNode?): Boolean {
        if (root == null) {
            return false
        }
        return recursive(root) != -1
    }

    private fun recursive(root: TreeNode?): Int {
        if (root == null) {
            return 0
        } else if (root.left == null && root.right == null) {
            return 1
        } else if (root.left != null && root.right != null) {
//            判断左右子树
            if (root.left!!.`val` >= root.`val`) {
                return -1
            }
            if (root.right!!.`val` <= root.`val`) {
                return -1
            }
        }
        val leftDepth = recursive(root.left)
        val rightDepth = recursive(root.right)
        if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) {
            return -1
        }
        return Math.max(leftDepth, rightDepth) + 1
    }
}