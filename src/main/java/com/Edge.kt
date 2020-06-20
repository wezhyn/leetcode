package com

import java.util.*
import kotlin.collections.ArrayList

/**
 *
 * @author wezhyn
 * @since 06.16.2020
 *
 */
class Edge<T : Comparable<T>>(val from: Int, val to: Int, val weight: T) : Comparable<Edge<T>> {

    override fun toString(): String {
        return "Edge(from=$from, to=$to, weight=$weight)"
    }

    fun isSelfConnect(): Boolean = from == to
    override fun compareTo(other: Edge<T>): Int {
        return weight.compareTo(other.weight)
    }
}

interface Graph<T : Comparable<T>> {

    fun adjacency(v: Int): Array<Edge<T>>

    fun graph(): Array<Array<Edge<T>>>

    fun v(): List<Int> {
        val result = ArrayList<Int>()
        for (i in graph().indices) {
            result.add(i)
        }
        return result
    }

}

class EdgeGraph<T>(val vertex: Int, private val twoDimensional: Array<Array<T>>) : Graph<T>
        where T : Number, T : Comparable<T> {

    private val graph: Array<Array<Edge<T>>>
    private val edgeNum: Int

    init {
        var en = 0
        graph = Array(twoDimensional.count()) { from ->
            val ints = twoDimensional[from]
            en += ints.count()
            Array(ints.size) { to -> Edge(from, to, ints[to]) }
        }
        edgeNum = en
    }

    override fun toString(): String {
        val sb = StringBuilder()
        graph.forEach { edges ->
            if (edges.isNotEmpty()) {
                sb.append("v start from ${edges[0].from} to :")
            }
            edges.forEach {
                sb.append("(${it.to},${it.weight})")
            }
            if (edges.isNotEmpty()) {
                sb.append("\n")
            }

        }
        return "EdgeGraph(vertex=$vertex, graph=\n$sb)"
    }

    override fun adjacency(v: Int): Array<Edge<T>> = graph[v].copyOf()

    fun edges(): List<Edge<T>> {
        val result = ArrayList<Edge<T>>(vertex * vertex)
        graph.forEach { line ->
            result.addAll(line.copyOf())
        }
        return result
    }

    inner class KruskalMst : MST<T> {
        override fun spanningTree(): List<Edge<T>> {
            val queue = PriorityQueue<Edge<T>>(vertex * vertex)
            val result = ArrayList<Edge<T>>(vertex * vertex)
            queue.addAll(this@EdgeGraph.edges())
            val uf = UF(vertex)
            while (queue.isNotEmpty()) {
                val edge = queue.poll()
                if (uf.connected(edge.from, edge.to)) {
                    continue
                }
                uf.union(edge.from, edge.to)
                result.add(edge)
            }
            return result
        }

    }


    inner class LazyPrimMst : MST<T> {
        override fun spanningTree(): List<Edge<T>> {
            val out = this@EdgeGraph
            val marked = BooleanArray(out.vertex) { false }
            val queue = PriorityQueue<Edge<T>>()
            val result = ArrayList<Edge<T>>()
            queue.add(Edge(0, 0, 0.0 as T))
            while (queue.size > 0) {
                val edge = queue.poll()
                if (!marked[edge.to]) {
                    marked[edge.to] = true
                    if (!edge.isSelfConnect()) {
                        result.add(edge)
                    }
                    queue.addAll(adjacency(edge.to))
                }
            }
            return result
        }
    }

    override fun graph(): Array<Array<Edge<T>>> {
        return graph.copyOf()
    }
}

class DirectedEdgeGraph<T>(private val vertex: Int, edges: List<Edge<T>>) : Graph<T>
        where T : Comparable<T>, T : Number {

    private val graph: Array<MutableList<Edge<T>>> = Array(vertex) { ArrayList<Edge<T>>() }

    init {
        for (edge in edges) {
            graph[edge.from].add(edge)
        }
    }

    override fun adjacency(v: Int): Array<Edge<T>> {
        return graph[v].toTypedArray()
    }

    inner class Dijkstra {
        private lateinit var edgeTo: Array<Edge<T>?>
        private lateinit var distTo: Array<Double>
        fun sp(): Array<Edge<T>?> {
            val out = this@DirectedEdgeGraph
            edgeTo = Array(out.vertex) { null }
            distTo = Array(out.vertex) { if (it == 0) 0.0 else Double.MAX_VALUE }
//            weight int
            val queue = TreeMap<Double, Int>().apply { put(0.0, 0) }
            while (queue.isNotEmpty()) {
                val v = queue.pollFirstEntry().value
                val vertexEdges = out.graph[v].forEach { edge ->
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

    override fun graph(): Array<Array<Edge<T>>> {
        return Array(graph.size) { graph[it].toTypedArray() }
    }

}
