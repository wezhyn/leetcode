package com.wezhyn.learn

import org.junit.Test
import java.nio.file.Paths

/**
 *
 *
 * @author wezhyn
 * @since 06.20.2020
 */
class TopologicalSortTest {

    @Test
    fun order() {
        val graph = Paths.get("src/main/resources/tinyEWDAG.txt")
                .loadDirectEdgeGraph<Double>()
        TopologicalSort(graph).order().forEach(System.out::println)
    }
}