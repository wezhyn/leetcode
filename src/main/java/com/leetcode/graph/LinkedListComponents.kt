package com.leetcode.graph

import com.ListNode

/**
 * 给定一个 List ，和一个 subList ,求 subList 中的连通分量
 * https://leetcode.com/problems/linked-list-components/
 * Example 1:
 * Input:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 *
 * Example 2:
 * Input:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 *
 * @author wezhyn
 * @since 06.22.2020
 *
 */
class LinkedListComponents {


    fun numComponents(head: ListNode?, G: IntArray): Int {
        val map = HashSet<Int>()
        G.forEach { map.add(it) }
        var count = 0
        var isConnect = false
        var cur = head
        while (cur != null) {
            if (map.contains(cur.`val`) && !isConnect) {
                isConnect = true
                count++
            }
            if (!map.contains(cur.`val`)) {
                isConnect = false
            }
            cur = cur.next
        }
        return count
    }
}