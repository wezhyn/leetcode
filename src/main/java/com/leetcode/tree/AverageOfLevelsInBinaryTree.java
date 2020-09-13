package com.leetcode.tree;

import java.util.*;

/**
 * @author wezhyn
 * @since 09.12.2020
 */
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> results = new ArrayList<>();
        TreeNode flag = new TreeNode(-1);
        queue.offer(root);
        queue.offer(flag);
        double aveSum = 0;
        int aveNum = 0;
        while (!queue.isEmpty()) {
            final TreeNode poll = queue.poll();
            if (poll == flag) {
                results.add(aveSum / aveNum);
                aveNum = 0;
                aveSum = 0;
                if (!queue.isEmpty()) {
                    queue.add(flag);
                }
            } else {
                aveSum += poll.val;
                aveNum++;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return results;
    }
}
