package com.wezhyn.learn

import java.util.*

/**
 *
 * @author wezhyn
 * @since 06.16.2020
 *
 */
/**
 * 可以处理环，但无法处理负权重
 * Dijkstra 假设已经发现的节点之间已经是最短路径
 */
class Dijkstra<T>(val graph: DirectedEdgeGraph<T>)
        where T : Comparable<T>, T : Number {
    private lateinit var edgeTo: Array<Edge<T>?>
    private lateinit var distTo: Array<Double>
    fun sp(): Array<Edge<T>?> {
        val vertexNum = graph.v().size
        edgeTo = Array(vertexNum) { null }
        distTo = Array(vertexNum) { if (it == 0) 0.0 else Double.MAX_VALUE }
//            weight int
        val queue = TreeMap<Double, Int>().apply { put(0.0, 0) }
        while (queue.isNotEmpty()) {
            val v = queue.pollFirstEntry().value
            val vertexEdges = graph.adjacency(v).forEach { edge ->
                val oldDis = distTo[edge.to]
                val newDis = distTo[edge.from] + edge.weight.toDouble()
                if (oldDis > newDis) {
                    edgeTo[edge.to] = edge
                    distTo[edge.to] = newDis
                    if (queue.containsValue(edge.to)) {
                        queue.replace(oldDis, edge.to)
                    }
                    queue[newDis] = edge.to
                }
            }
        }
        return edgeTo
    }
}

/**
 *  可以处理负权边，但是不能处理负权重环【环上所有边的权重之和小于0】，时间复杂度比Dijkstra较高
 *  主要思想：如果没有负权环，从图中任意一点到另外一点的最短路径，最多经过 n 个节点，n-1 条边
 *
 *  @see com.leetcode.CheapestFlightsWithinKStops BellmanFord 小变种
 *
 *  > 还可以用来判断是否有负权环，当从给定一点到另外一点经过的顶点数 > N 表示存在一个负权环
 */
class BellmanFord<T>(private val graph: DirectedEdgeGraph<T>)
        where T : Comparable<T>, T : Number {

    private lateinit var distTo: Array<Double>
    private lateinit var pathTo: Array<Edge<T>?>
    fun sp(): Array<Edge<T>?> {
        val vs = graph.v()
        val vertexNum = vs.size
        distTo = Array(vertexNum) { Double.MAX_VALUE }
        distTo[0] = 0.0
        pathTo = Array(vertexNum) { null }
        for (pass in 0 until vertexNum) {
            for (v in vs) {
                for (e in graph.adjacency(v)) {
                    val oldDis = distTo[e.to]
                    val newDis = distTo[e.from] + e.weight.toDouble()
                    if (oldDis > newDis) {
                        distTo[e.to] = newDis
                        pathTo[e.to] = e
                    }
                }
            }
        }
        return pathTo
    }

}
