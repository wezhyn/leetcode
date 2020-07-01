package com

/**
 *
 * @author wezhyn
 * @since 07.01.2020
 *
 */
fun <T : Comparable<T>> quickSort(array: Array<T>) {
    if (array.isEmpty()) {
        return
    }
    partition(array, 0, array.size - 1)
}


private fun <T : Comparable<T>> partition(array: Array<T>, l: Int, r: Int) {
    if (l >= r) {
        return
    }
    val medium = doPartition(array, l, r)
    partition(array, l, medium - 1)
    partition(array, medium, r)
}

/**
 * 以 flag 为标识，i 为当前正在排序的位置，如果arr[i]小于flag的放置在 (l,m) ，大于flag 的不动
 */
private fun <T : Comparable<T>> doPartition(array: Array<T>, l: Int, r: Int): Int {
    if (l >= r) {
        return l
    }
    val flag = array[l]
//    medium 指向下一个平衡的位置
    var medium = l + 1
    for (i in l + 1..r) {
        when (array[i] >= flag) {
            false -> {
                val m = array[medium]
                array[medium] = array[i]
                array[i] = m
                medium++
            }
            true -> {
            }
        }
    }
    array[l] = array[medium - 1]
    array[medium - 1] = flag
    return medium
}