package com

/**
 * 成环检测
 * @author wezhyn
 * @since 06.16.2020
 *
 */
class UF(private val n: Int) {
    private val ids = Array<Int>(n) { it }

    private fun find(_p: Int): Int {
        var p = _p
        while (p != ids[p]) {
            p = ids[p]
        }
        return p
    }

    fun union(p: Int, q: Int) {
        val pr = find(p)
        val qr = find(q)
        if (pr == qr) {
            return
        }
        ids[pr] = qr
    }

    fun connected(p: Int, q: Int): Boolean = find(p) == find(q)
}