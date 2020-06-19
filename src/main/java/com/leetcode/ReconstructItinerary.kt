package com.leetcode

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * https://www.youtube.com/watch?v=4udFSOWQpdg
 *
 *
 * 对于一个节点（当然先从JFK开始)，贪心地访问最小的邻居，访问过的边全部删除。
 * 当碰到死路的时候就回溯到最近一个还有出路的节点，然后把回溯的路径放到最后去访问，这个过程和后序遍历的一样。
 * 1. 如果子节点没有死路（每个节点都只左子树），前序遍历便是欧拉路径。
 * 2. 如果子节点1是死路，子节点2完成了遍历，那么子节点2先要被访问。1，2都和后序遍历的顺序正好相反
 *
 * 知识补充：
 * 欧拉图： 图G上有一条经过所有边、所有顶点的闭路径【边不可以重复，顶点可以重复】，这条路径叫做欧拉路径
 * 充分必要条件：
 * 无向图：G 连通，所有顶点的度为偶数
 * 有向图：弱连通，所有顶点的出度与入度相等
 *
 *
 *
 *
 *
 * @author wezhyn
 * @since 06.18.2020
 *
 */
class ReconstructItinerary {
    companion object {
        const val START = "JFK"
    }

    private lateinit var result: MutableList<String>

    fun findItinerary(tickets: List<List<String>>): List<String> {
        val map = HashMap<String, Queue<String>>()
        tickets.forEach {
            val list = map.getOrPut(it.get(0)) { PriorityQueue<String>() }
            list.add(it.get(1))
        }
        result = ArrayList<String>()
        dfs(map, START)
        return result.reversed()
    }

    private fun dfs(tickets: Map<String, Queue<String>>, arrival: String) {
        try {
            val avaiables = tickets[arrival] ?: return
            while (avaiables.isNotEmpty()) {
                val next = avaiables.poll() ?: return
                dfs(tickets, next)
            }
        } finally {
            result.add(arrival)
        }
    }

}