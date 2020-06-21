package com.template

/**
 *
 * @author wezhyn
 * @since 06.21.2020
 *
 */
private class Edge<T>(val from: Int, val to: Int, val weight: T) : Comparable<Edge<T>>
        where T : Comparable<T>, T : Number {

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

    operator fun get(index: Int): Array<Edge<T>> = adjacency(index)

    init {
        for (edge in edges) {
            graph[edge.from].add(edge)
        }
    }

    fun v(): List<Int> {
        val result = ArrayList<Int>()
        for (i in graph.indices) {
            result.add(i)
        }
        return result
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
