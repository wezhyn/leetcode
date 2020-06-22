package com.leetcode.graph

import com.DirectedEdgeGraph
import com.Edge
import com.get
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 *
 * We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever.
 * For example if routes[0] = [1, 5, 7],
 * this means that the first bus (0-th indexed) travels in the sequence 1->5->7->1->5->7->1->... forever.
 *
 * We start at bus stop S (initially not on a bus), and we want to go to bus stop T.
 * Travelling by buses only, what is the least number of buses we must take to reach our destination?
 * Return -1 if it is not possible.
 *
 * Example 1
 * Input:
 * routes = [[1, 2, 7], [3, 6, 7]]
 * S = 1
 * T = 6
 * Output: 2
 * Explanation:
 * The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
 *
 * 需要主义的点：
 *  可能在同一辆车次
 *  同能是相同站点和相同终点
 *
 * @author wezhyn
 * @since 06.22.2020
 *
 *
 *
 */
class BusRoutes {

    /**
     * 0：1次
     * -1： 不在同一车次
     */
    private fun checkInRoute(arr: IntArray, S: Int, T: Int): Int {

        for (v in arr) {
            if (v == T) {
                return 1
            }
        }
        return -1
    }

    fun numBusesToDestination(routes: Array<IntArray>, S: Int, T: Int): Int {
        val edges = ArrayList<Edge<Int>>()
        var maxVertex = Int.MIN_VALUE
        val busRoute = HashMap<Int, IntArray>()
        var initBusS: IntArray? = null
        var initRoute: Int? = null
        if (S == T) return 0
        for ((r, arr) in routes.withIndex()) {
            for ((i, v) in arr.withIndex()) {
                if (v == S) {
                    initBusS = arr
                    val inRoute = checkInRoute(arr, S, T)
                    if (inRoute >= 0) {
                        return inRoute
                    }
                    initRoute = r
                }
                val j = (i + 1) % arr.size
                maxVertex = maxVertex.coerceAtLeast(arr[i])
//                使用weight 代表当前乘坐的第几辆车,相同weight 代表同一辆车
                edges.add(Edge(arr[i], arr[j], r))
            }
            busRoute[r] = arr
        }
        val graph = DirectedEdgeGraph(maxVertex + 1, edges)
//        true : 访问过该节点
        if (initBusS == null || initRoute == null) {
            return -1
        }
//        当前车次是否已经做过
        val visited = BooleanArray(routes.size) { false }
        val queue = LinkedList<Pair<IntArray, Int>>().apply { add(Pair(initBusS, 1)) }
        visited[initRoute] = true
        while (queue.isNotEmpty()) {
            val currentRoute = queue.poll()
            for (route in currentRoute.first) {
                if (route == T) {
                    return currentRoute.second
                }
                for (edge in graph[route]) {
                    if (!visited[edge.weight]) {
                        visited[edge.weight] = true
                        queue.add(Pair(busRoute.get(edge.weight)!!, currentRoute.second + 1))
                    }
                }
            }
        }
        return -1
    }
}
