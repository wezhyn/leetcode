package com

import org.junit.Test
import java.nio.file.Paths

/**
 * @author wezhyn
 * @since 06.20.2020
 */
class UtilsKtTest {

    @Test
    fun util() {

        val s = "{0, 1, 2, 3, 4}," +
                "{1, 0, 5, 0, 7}," +
                "{2, 5, 0, 6, 0}," +
                "{3, 0, 6, 0, 0}," +
                "{4, 7, 0, 0, 0}"
        s.twoArray(prefix = "{", suffix = "}") { it.toInt() }
                .forEach { print(it.contentToString()) }

        val directEdgeGraph = Paths.get("src/main/resources/tinyEWD.txt")
                .loadDirectEdgeGraph<Double>().Dijkstra().sp()
        println(directEdgeGraph.contentDeepToString())
    }
}