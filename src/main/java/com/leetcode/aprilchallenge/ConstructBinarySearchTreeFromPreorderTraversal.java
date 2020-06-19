package com.leetcode.aprilchallenge;

import com.TreeNode;
import org.junit.Test;

/**
 * 划分区间构造更小的搜索树【不会】
 *
 * @author wezhyn
 * @since 04.21.2020
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {

    @Test
    public void test() {
        TreeNode.Companion.traverseBfsWithNull(bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12}));
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return tree(preorder, 0, preorder.length - 1);
    }

    public TreeNode tree(int[] preorder, int from, int to) {
        if (from > to) return null;
        TreeNode root = new TreeNode(preorder[from]);
        boolean found = false;
        for (int i = from + 1; i <= to; ++i) {
            if (preorder[i] > preorder[from]) {
                root.setLeft(tree(preorder, from + 1, i - 1));
                root.setRight(tree(preorder, i, to));
                found = true;
                break;
            }
        }
        if (!found) {
            root.setLeft(tree(preorder, from + 1, to));
        }

        return root;
    }

}
