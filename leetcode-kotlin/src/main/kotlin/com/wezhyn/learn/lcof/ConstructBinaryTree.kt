package com.wezhyn.learn.lcof

import com.wezhyn.learn.TreeNode

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * 观察先序和中序，可以发现，根节点在中序遍历中将左右子树分割，左边是左子树，右边是右子树
 * Example :
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * 在中序中，切分成 left: preorder [9] inorder[9]
 * left : preorder[20,15,7] ,inorder [15,20,7]
 * 通过递归调用这一个过程，可以构建一棵完整的二叉树
 *
 *
 * @author wezhyn
 * @since 06.26.2020
 *
 */
class ConstructBinaryTree {


    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) {
            return null
        }
        if (preorder.size == 1) {
            return TreeNode(preorder[0])
        }
        val rootVal = preorder[0]
        val root = TreeNode(rootVal)
        val rootIndex = inorder.indexOf(rootVal)
        root.left = buildTree(preorder.copyOfRange(1, rootIndex + 1), inorder.copyOfRange(0, rootIndex))
        root.right = buildTree(preorder.copyOfRange(rootIndex + 1, preorder.size), inorder.copyOfRange(rootIndex + 1, inorder.size))
        return root
    }
}