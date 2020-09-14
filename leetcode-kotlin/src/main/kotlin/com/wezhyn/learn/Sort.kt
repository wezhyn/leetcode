package com.wezhyn.learn

import kotlin.random.Random

/**
 * 快排 - 归并
 * @author wezhyn
 * @since 07.01.2020
 *
 */

fun <T : Comparable<T>> mergeSort(array: Array<T>) {

    var step = 2
    while (step <= array.size) {
        for (i in array.indices step step) {
            doMerge(array, i, i + step / 2 - 1, Math.min(i + step - 1, array.size - 1))
            if (i + 2 * step > array.size) {
                doMerge(array, i, i + step - 1, array.size - 1)
                break
            }
        }
        step *= 2
    }
}

// array [l,r]
private fun <T : Comparable<T>> doMerge(array: Array<T>, l: Int, medium: Int, r: Int) {
    if (l >= r) {
        return
    }
//    0 起步
    val copy = array.copyOfRange(l, r + 1)
    var li = 0
    val mi = medium - l
    var ri = mi + 1
    for (i in l..r) {
        val left = if (li <= mi) copy[li] else null
        val right = if (ri <= r - l) copy[ri] else null
        if (left != null && right != null) {
            if (left < right) {
                array[i] = left
                li++
            } else {
                array[i] = right
                ri++
            }
        } else if (left == null) {
            array[i] = right!!
            ri++
        } else {
            array[i] = left
            li++
        }
    }

}

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