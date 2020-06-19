package com

import java.nio.file.Paths
import java.util.*

/**
 *
 * @author wezhyn
 * @since 06.18.2020
 *
 */
fun main() {
    val graph = Paths.get("src/main/resources/tinyEWDAG.txt")
            .loadDirectEdgeGraph<Double>()
    TopologicalSort(graph).order().forEach(System.out::println)
}

class TopologicalSort<T>(private val graph: Graph<T>) where T : Comparable<T> {


    private val order = Stack<Int>()
    private val marked = BooleanArray(graph.v().size) { false }


    fun order(): Iterable<Int> = order.asReversed()

    init {
        for (i in graph.v()) {
            if (!marked[i]) {
                dfs(graph, i)
            }
        }
    }

    private fun dfs(graph: Graph<T>, v: Int) {
        marked[v] = true
        for (e in graph.adjacency(v)) {
            val w = e.to
            if (!marked[w]) {
                dfs(graph, w)
            }
        }
        order.push(v)
    }

}