package com.wezhyn.learn

/**
 *
 * @author wezhyn
 * @since 07.02.2020
 *
 */
fun String.intList(delimiter: String = ","): List<Int> {
    return this.oneList(delimiter) { it.toInt() }
}

fun String.intArray(delimiter: String = ","): IntArray {
    return this.onePrimitiveArray { it.toInt() }
}

fun <T> Array<T>.swap(l: Int, r: Int) {
    val array = this
    require(l < array.size)
    require(r < array.size)
    val left = array[l]
    array[l] = array[r]
    array[r] = left
}

fun IntArray.swap(l: Int, r: Int) {
    val array = this
    require(l < array.size)
    require(r < array.size)
    val left = array[l]
    array[l] = array[r]
    array[r] = left
}