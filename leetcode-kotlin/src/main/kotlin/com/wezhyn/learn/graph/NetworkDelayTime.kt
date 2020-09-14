package com.wezhyn.learn.graph

import com.wezhyn.learn.DirectedEdgeGraph
import com.wezhyn.learn.Edge
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

/**
 *
 * 给定n 个节点，求从给定节点到达其他节点的最大值
 * [u,v,w] : u from ,v desc,w: 距离
 *
 *  times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 *  https://assets.leetcode.com/uploads/2019/05/23/931_example_1.png
 *
 *  使用 Dijkstra 求得到每一个节点的最小距离，返回其中最远的位置
 * @author wezhyn
 * @since 06.20.2020
 *
 */
class NetworkDelayTime {
    fun networkDelayTime(times: Array<IntArray>, N: Int, K: Int): Int {
        val edges = ArrayList<Edge<Int>>()
        times.forEach { row ->
            edges.add(Edge(row[0], row[1], row[2]))
        }
        val pathTo = Array(N + 1) { Edge(-1, -1, -1) }
        val visit = BooleanArray(N + 1) { false }
        val graph = DirectedEdgeGraph(N + 1, edges)
        val distanceTo = IntArray(N + 1) { Int.MAX_VALUE }
        distanceTo[K] = 0
//        由于没有使用第一个节点
        distanceTo[0] = 0
//        由于使用优先级队列，所以 0.1,1 一定排在 0.2 ,1前
        val queue = PriorityQueue(Comparator<Pair<Int, Int>> { t1, t2 -> t1.first.compareTo(t2.first) })
        queue.add(Pair(0, K))
        while (queue.isNotEmpty()) {
            val nextVertex = queue.poll()
            val v = nextVertex.second
            if (!visit[v]) {
                visit[v] = true
                for (ae in graph.adjacency(v)) {
                    val to = ae.to
                    val oldDis = distanceTo[to]
                    val newDis = distanceTo[ae.from] + ae.weight
                    if (oldDis > newDis) {
                        distanceTo[to] = newDis
                        pathTo[to] = ae
                        queue.offer(Pair(newDis, to))
                    }
                }
            }
        }
        val max = distanceTo.max() ?: -1
        return if (max == Int.MAX_VALUE) {
            -1
        } else {
            max
        }

    }
}