package com

import java.nio.file.Path
import java.util.*
import kotlin.collections.ArrayList

/**
 *
 * @author wezhyn
 * @since 06.15.2020
 *
 */

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

/**
 * T: IntArray ,R :int
 * T: BooleanArray,R:Boolean
 */
inline fun <reified T, reified R : Any> String.twoPrimitiveArray(prefix: String = "[", suffix: String = "]", segmentation: String = ",",
                                                                 convert: (String) -> R): Array<T> {
    return twoListArray<T, R>(prefix, suffix, segmentation, convert).toTypedArray()
}

/**
 * T: IntArray ,R :int
 * T: BooleanArray,R:Boolean
 */
inline fun <reified R : Any> String.twoArray(prefix: String = "[", suffix: String = "]", segmentation: String = ",",
                                             convert: (String) -> R): Array<Array<R>> {
    val twoList = twoList(prefix, suffix, segmentation, convert)
    if (twoList.isEmpty()) return emptyArray()

    val ans = Array<Array<R>>(twoList.size) {
        twoList[it].toTypedArray()
    }
    return ans
}

/**
 * T: IntArray ,R :int
 * T: BooleanArray,R:Boolean
 */
inline fun <reified T, reified R : Any> String.twoListArray(prefix: String = "[", suffix: String = "]", segmentation: String = ",",
                                                            convert: (String) -> R): List<T> {
    val result = this.twoList(prefix, suffix, segmentation, convert)
    if (result.isEmpty()) {
        return emptyList()
    }
    val ans = ArrayList<T>()
    val jclass = T::class.java
    if (!jclass.isArray) {
        throw IllegalArgumentException("非数组类型")
    }
    for ((i, list) in result.withIndex()) {
        val array = java.lang.reflect.Array.newInstance(R::class.javaPrimitiveType, list.size)
        for ((index, element) in list.withIndex()) {
            val field = element::class.java.getDeclaredField("value")
            field.isAccessible = true
            java.lang.reflect.Array.set(array, index, field.get(element))
        }
        ans.add(array as T)
    }
    return ans
}

inline fun <reified R : Any> String.twoList(prefix: String = "[", suffix: String = "]", segmentation: String = ",",
                                            convert: (String) -> R): List<List<R>> {
    val result = ArrayList<MutableList<R>>()
    var l = 0
    var r = 0
    while (r != -1 && l != -1) {
        l = this.indexOf(prefix, l)
        r = this.indexOf(suffix, r)
        if (r == -1 || l == -1) {
            break
        }
        val elementArray = this.substring(l + 1, r).split(segmentation, ignoreCase = true)
        result.add(ArrayList())
        for (e in elementArray) {
            result[result.size - 1].add(convert.invoke(e.trim()))
        }
        l = r
        r++
    }
    return result
}
