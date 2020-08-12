package com.leetcode.aprilchallenge;

import com.TreeNode;

/**
 * 寻找最长路径，遍历根节点左右，寻找层数最高的左右两个节点
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3293/
 *
 * @author wezhyn
 * @since 04.12.2020
 */
public class DiameterOfBinaryTree {


    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfsRoot(root, root).maxDiameter;
    }

    public TraverseResult dfsRoot(TreeNode node, TreeNode root) {
        if (node.getLeft() == null && node.getRight() == null) {
            return new TraverseResult(0, 0);
        }
        TraverseResult lLen = new TraverseResult(0, 0);
        TraverseResult rLen = new TraverseResult(0, 0);
        if (node.getLeft() != null) {
            TraverseResult l = dfsRoot(node.getLeft(), root);
            lLen.maxLen = l.maxLen + 1;
            lLen.maxDiameter = Math.max(lLen.maxDiameter, l.maxDiameter);
        }
        if (node.getRight() != null) {
            TraverseResult r = dfsRoot(node.getRight(), root);
            rLen.maxLen = r.maxLen + 1;
            rLen.maxDiameter = Math.max(rLen.maxDiameter, r.maxDiameter);
        }
//        当前节点遍历完后，返回当前节点最长的路径长度
        return new TraverseResult(Math.max(lLen.maxLen, rLen.maxLen), Math.max(rLen.maxLen + lLen.maxLen, Math.max(rLen.maxDiameter, lLen.maxDiameter)));
    }

    public static class TraverseResult {
        /**
         * 最长路径
         */
        int maxLen;
        /**
         * 当前节点最大的边结果
         */
        int maxDiameter;

        public TraverseResult(int maxLen, int maxDiameter) {
            this.maxLen = maxLen;
            this.maxDiameter = maxDiameter;
        }
    }

}
