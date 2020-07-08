package com

import kotlin.random.Random

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
    val medium = doDoublePartition(array, l, r)
    partition(array, l, medium - 1)
    partition(array, medium, r)
}

/**
 * 将给定数组排序成 (l,li) < flag  (ri,r]>flag
 */
private fun <T : Comparable<T>> doDoublePartition(array: Array<T>, l: Int, r: Int): Int {
    if (l >= r) {
        return l
    }
    val flag = randomSwap(array, l, r)
    var li = l + 1
    var ri = r
    while (true) {
        while (li <= ri && array[li] < flag) {
            li++
        }
        while (ri >= li && array[ri] > flag) {
            ri--
        }
        if (li < ri) {
            array.swap(li, ri)
            li++
            ri--
        } else {
            break
        }
    }
    array.swap(l, li - 1)
    return li

}

/**
 * 以 flag 为标识，i 为当前正在排序的位置，如果arr[i]小于flag的放置在 (l,m) ，大于flag 的不动
 */
private fun <T : Comparable<T>> doPartition(array: Array<T>, l: Int, r: Int): Int {
    if (l >= r) {
        return l
    }
    val flag = randomSwap(array, l, r)
//    medium 指向下一个平衡的位置
    var medium = l + 1
    for (i in l + 1..r) {
        when (array[i] >= flag) {
            false -> {
                array.swap(medium, i)
                medium++
            }
            true -> {
            }
        }
    }
    array.swap(medium - 1, l)
    return medium
}

private fun <T : Comparable<T>> randomSwap(array: Array<T>, l: Int, r: Int): T {
    require(r >= l)
    val i = Random(System.currentTimeMillis()).nextInt(r - l + 1) + l
    val result = array[i]
    array.swap(i, l)
    return result
}