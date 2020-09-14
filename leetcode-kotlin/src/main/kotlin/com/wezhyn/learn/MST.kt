package com.wezhyn.learn

/**
 *
 * @author wezhyn
 * @since 06.16.2020
 *
 */
interface MST<T : Comparable<T>> {


    fun spanningTree(): List<Edge<T>>
}