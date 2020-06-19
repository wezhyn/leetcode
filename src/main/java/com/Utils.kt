package com

import java.nio.file.Path
import java.nio.file.Paths
import java.util.*
import kotlin.collections.ArrayList

/**
 *
 * @author wezhyn
 * @since 06.15.2020
 *
 */

fun main() {
    val s = "{0, 1, 2, 3, 4}," +
            "{1, 0, 5, 0, 7}," +
            "{2, 5, 0, 6, 0}," +
            "{3, 0, 6, 0, 0}," +
            "{4, 7, 0, 0, 0}"
    s.twoDimensional('{')
            .forEach { print(Arrays.toString(it)) }

    val directEdgeGraph = Paths.get("src/main/resources/tinyEWD.txt")
            .loadDirectEdgeGraph<Double>().Dijkstra().sp()
    println(directEdgeGraph.contentDeepToString())
}

inline fun runTime(action: (Unit) -> Unit) {
    val startTime = System.currentTimeMillis()
    action.invoke(Unit)
    val endTime = System.currentTimeMillis()
    println("average run time ${endTime - startTime} ms")
}

inline fun <reified T> Path.loadDirectEdgeGraph(): DirectedEdgeGraph<T>
        where T : Comparable<T>, T : Number {
    return Scanner(this).use {
        val vertex = it.nextInt()
        val edges = it.nextInt()
        val result = ArrayList<Edge<T>>(edges)
        for (i in 1..edges) {
            when (T::class) {
                Int::class -> result.add(Edge(it.nextInt(), it.nextInt(), it.nextInt() as T))
                Double::class -> result.add(Edge(it.nextInt(), it.nextInt(), it.nextDouble() as T))
            }

        }
        return@use DirectedEdgeGraph(vertex, result)
    }
}

fun String.oneDimensional(): List<Int> {
    val result = ArrayList<Int>()
    for (i in this.indices) {
        val c: Char = this[i]
        if (c.isDigit()) {
            result.add(c - '0')
        }
    }
    return result
}

fun String.twoDimensional(segmentation: Char = '['): Array<Array<Int>> {
    val result: MutableList<MutableList<Int>> = ArrayList()
    for (i in this.indices) {
        val c: Char = this[i]
        if (c == segmentation) {
            result.add(ArrayList())
        }
        if (c.isDigit()) {
            result[result.size - 1].add(c - '0')
        }
    }
    if (result.size == 0) {
        return Array(0) { Array<Int>(0) { 0 } }
    }
    val ans = Array(result.size) { Array<Int>(result[0].size) { 0 } }
    for (i in result.indices) {
        val r: List<Int> = result[i]
        for (i1 in r.indices) {
            ans[i][i1] = r[i1]
        }
    }
    return ans

}