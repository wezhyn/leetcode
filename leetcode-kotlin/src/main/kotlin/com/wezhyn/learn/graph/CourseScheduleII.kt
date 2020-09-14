package com.wezhyn.learn.graph

import com.wezhyn.learn.DirectedEdgeGraph
import com.wezhyn.learn.createDirectEdgeGraph


/**
 *
 * @author wezhyn
 * @since 06.21.2020
 *
 */
class CourseScheduleII {

    /**
     * 已经访问过的课
     */
    private lateinit var result: MutableList<Int>

    //    -1 未访问，0正在访问，1 已经访问完
    private lateinit var visit: IntArray

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        result = ArrayList()
        visit = IntArray(numCourses) { -1 }
        val graph = createDirectEdgeGraph(twoArray = prerequisites, vertex = numCourses, hasWeight = false)
        for ((i, v) in visit.withIndex()) {
            if (v == -1) {
                if (topological(graph, i)) {
//                    冲突
                    return IntArray(0)
                }
            }
        }
        return result.toIntArray()
    }


    private fun topological(graph: DirectedEdgeGraph<Int>, course: Int): Boolean {
        try {
            if (visit[course] == 0) {
                return true
            }
            var result = false
            val adjacencyEdge = graph.adjacency(course)
            for (e in adjacencyEdge) {
                when (visit[e.to]) {
                    0 -> return true
                    -1 -> {
                        visit[course] = 0
                        result = result || topological(graph, e.to)
                    }
                }
            }
            return result
        } finally {
            result.add(course)
            visit[course] = 1
        }
    }
}

