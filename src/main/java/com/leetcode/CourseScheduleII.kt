package com.leetcode


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

private class Edge<T : Comparable<T>>(val from: Int, val to: Int, val weight: T) : Comparable<Edge<T>> {

    override fun toString(): String {
        return "Edge(from=$from, to=$to, weight=$weight)"
    }

    fun isSelfConnect(): Boolean = from == to
    override fun compareTo(other: Edge<T>): Int {
        return weight.compareTo(other.weight)
    }
}

private class DirectedEdgeGraph<T>(private val vertex: Int, edges: List<Edge<T>>)
        where T : Comparable<T>, T : Number {

    private val graph: Array<MutableList<Edge<T>>> = Array(vertex) { ArrayList<Edge<T>>() }

    init {
        for (edge in edges) {
            graph[edge.from].add(edge)
        }
    }

    fun adjacency(v: Int): Array<Edge<T>> {
        return graph[v].toTypedArray()
    }
}

private fun createIntEdge(hasWeight: Boolean = true, array: IntArray, defaultWeight: Int = 1): Edge<Int> {
    val w = if (hasWeight) array[2] else defaultWeight
    return Edge(array[0], array[1], w)
}

private fun createDirectEdgeGraph(twoArray: Array<IntArray>, vertex: Int, hasWeight: Boolean = true): DirectedEdgeGraph<Int> {
    val result = ArrayList<Edge<Int>>()
    twoArray.forEach {
        result.add(createIntEdge(hasWeight = hasWeight, array = it))
    }
    return DirectedEdgeGraph(vertex, result)
}