package com

/**
 *
 * @author wezhyn
 * @since 06.21.2020
 *
 */
fun createIntEdge(hasWeight: Boolean = true, array: IntArray, defaultWeight: Int = 1): Edge<Int> {
    val w = if (hasWeight) array[2] else defaultWeight
    return Edge(array[0], array[1], w)
}

fun createDirectEdgeGraph(twoArray: Array<IntArray>, vertex: Int, hasWeight: Boolean = true): DirectedEdgeGraph<Int> {
    val result = ArrayList<Edge<Int>>()
    twoArray.forEach {
        result.add(createIntEdge(hasWeight = hasWeight, array = it))
    }
    return DirectedEdgeGraph(vertex, result)
}