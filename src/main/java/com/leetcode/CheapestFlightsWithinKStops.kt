package com.leetcode

import com.createDirectEdgeGraph
import com.get


/**
 *
 * 给定n个节点，求给定 S 到目标 V 最多经过几个节点的最短路径
 *
 * 使用最简单的 Bellman-Ford 算法解决
 * 略微不同的是，使用的是二维数组，由于原bellman-ford 一维数组，每一轮的改动在当前轮都会被知晓，不利于本题目
 *
 * 存在一个图 A->B->C->D  距离都是1
 * 原先的Bellman-ford 算法在第一轮就可以得出A-D的最短距离
 * 使用二维数组后，第一轮只能到达B，第二轮最远到达C，符合本题目
 *
 * > 小数量节点时，Bellman-Ford 写起来简单，方便
 *
 * @author wezhyn
 * @since 06.21.2020
 *
 */
class CheapestFlightsWithinKStops {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, K: Int): Int {
        val graph = createDirectEdgeGraph(flights, n)
        val vs = graph.v()
        val distTo = Array(K + 2) { IntArray(n) { if (it == src) 0 else 100000 } }
        for (pass in 1..K + 1) {
            for (v in vs) {
                for (e in graph[v]) {
                    distTo[pass][e.to] = Math.min(distTo[pass][e.to], distTo[pass - 1][e.from] + e.weight)
                }
            }
        }
        return if (distTo[K + 1][dst] >= 100000) -1 else distTo[K + 1][dst]
    }
}



