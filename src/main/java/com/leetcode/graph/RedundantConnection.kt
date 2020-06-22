package com.leetcode.graph

import com.UF

/**
 *
 * @author wezhyn
 * @since 06.19.2020
 *
 */
class RedundantConnection {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val uf = UF(edges.size + 1)
        for (arr in edges) {
            val u = arr[0]
            val v = arr[1]
            if (uf.connected(u, v)) {
                return arr
            } else {
                uf.union(u, v)
            }
        }
        return IntArray(0)
    }
}