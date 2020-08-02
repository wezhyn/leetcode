package com

import org.junit.Test

/**
 * @author wezhyn
 * @since 06.20.2020
 */
class EdgeTest {
    @Test
    fun test() {
        val s = "{3, 1, 2, 3, 4}," +
                "{1, 3, 5, 3, 7}," +
                "{2, 5, 3, 6, 3}," +
                "{3, 3, 6, 3, 3}," +
                "{4, 7, 3, 3, 3}"
        val twoDimensional = s.twoArray<Int>(prefix = "{", suffix = "}", convert = { it.toInt() })
        val graph = EdgeGraph(5, twoDimensional = twoDimensional)
        val spanningTree = graph.LazyPrimMst().spanningTree()
        println(spanningTree)
        val kruskalTree = graph.KruskalMst().spanningTree()
        println(kruskalTree)

    }
}