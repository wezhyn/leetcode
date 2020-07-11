package com

import java.util.*
import kotlin.collections.ArrayList

/**
 * https://leetcode.com/problems/design-skiplist/
 * 基于二叉思想的多链表
 * 每一个链表都是前一个链表的子链表
 * 在查找过程中，使用向左和向下两个操作，即可完成整个链表的遍历，在查找的过程中，可以跳过部分节点
 * 其中每一层都是一个有序链表
 *
 * 节点的实现方式：
 * 原：使用 up down left right 维护
 * 先：使用 pre,List<next> ，level
 *
 * cur: 当前的节点 ，target：想要插入的数值
 * 原想的插入操作：
 * 1. 在插入过程中，只保证向下和向左查找
 * 2. 在查找过程中，遇到当前链表中最后一个比num小的元素，使用随机数判断是否需要在当前节点后插入target
 *
 * 更简洁的插入操作：
 * 1. 在插入过程中，只保证向下和向左查找
 * 2. 直到最下层中找到插入位置，将target 置成随机层高，如果当前随机层高大于当前最大层高，则从head中的每一层的末尾指向当前target
 *
 */
class Skiplist {

    /**
     * 指向每一层的一个元素
     */
    private val head = ArrayList<SkipListNode?>()

    /**
     * 当前层级
     */
    private var level = -1

    fun search(target: Int): Boolean {
        val h = headNode(target)
        if (h.second < 0) {
            return false
        }
        var curLevel = h.second
        var cur = h.first!!
        loop@ while (curLevel >= 0) {
//            当前节点值小于给定值
            when {
                cur.`val` < target -> {
                    val next = cur.next(curLevel)
                    if (next == null && curLevel == 0) {
                        return false
                    }
                    if (next?.`val` ?: Int.MAX_VALUE <= target) {
                        cur = cur.next(curLevel)!!
                        continue@loop
                    }
                    curLevel--
                }
                cur.`val` == target -> return true
            }
        }
        return false
    }

    fun add(num: Int) {
        val target = SkipListNode(num, randomLevel(level))
        var curLevel = Math.min(this.level, target.level)
        if (target.level > this.level) {
//            如果随机level大于当前level，代表添加了一个更高的层，需要添加头节点
            head.add(target)
            this.level++
        }
        var cur: SkipListNode? = if (curLevel < 0) return else head[curLevel]
        loop@ while (curLevel > -1) {
//            当前节点值小于给定值
            when {
                cur == null -> {
                    head[curLevel] = target
                    cur = head[--curLevel]
                }
                cur.`val` < num -> {
                    val next = cur.next(curLevel)
                    if (next == null) {
                        cur.initLevel(curLevel, target, true)
                    } else {
                        if (next.`val` < num) {
                            cur = cur.next(curLevel)!!
                            continue@loop
                        } else {
                            cur.initLevel(curLevel, target)
                        }
                    }
                    curLevel--
                }
                cur.`val` == num -> {
                    if (cur === target) {
                        return
                    }
//                    如果发现一个相等的，直接在尾端中插入
                    cur.initLevel(0, target)
                    return
                }
//                首节点倒序遍历
                cur.`val` > num -> {
                    target.initLevel(curLevel, head[curLevel], true)
                    head[curLevel] = target
                    if (curLevel > 0) {
                        cur = head[--curLevel]
                    } else {
                        return
                    }
                }
            }

        }
    }


    fun erase(num: Int): Boolean {
        val h = headNode(num)
        if (h.second < 0) {
            return false
        }
        var cur = h.first
        var curLevel = h.second
        var hasRemove = false
        var removeObject: SkipListNode? = null
        loop@ while (curLevel > -1) {
//            当前节点值小于给定值
            when {
                cur == null -> {
                    if (curLevel == 0) {
                        break@loop
                    }
                    cur = head[--curLevel]
                }
//                只匹配头节点，并且当前元素要被删除
                (removeObject === null && head[curLevel]?.`val` == num) ||
//                        当头节点等于要删除的节点
                        (removeObject != null && head[curLevel] === removeObject) -> {
                    if (removeObject == null) {
                        removeObject = head[curLevel]
                        hasRemove = true
                    }
                    head[curLevel] = head[curLevel]?.next(curLevel)
                    cur = if (curLevel > 0) head[--curLevel] else break@loop
                }
                cur.`val` <= num -> {
                    val next = cur.next(curLevel)
                    val nextVal = next?.`val` ?: Int.MAX_VALUE
                    if (nextVal <= num) {
                        if (nextVal == num && removeObject === null) {
                            removeObject = next
                        }
                        if (nextVal == num && removeObject === next && removeObject != null) {
                            hasRemove = true
                            cur.initLevel(curLevel, removeObject.next(curLevel), true)
                            curLevel--
                        } else {
                            cur = cur.next(curLevel)
                        }
                        continue@loop
                    }
                    curLevel--
                }
            }
        }
        return hasRemove
    }

    private fun headNode(num: Int): Pair<SkipListNode?, Int> {
        for ((i, v) in head.withIndex().reversed()) {
            v?.let {
                if (it.`val` <= num) {
                    return Pair(v, i)
                }
            }
        }
        return Pair(null, -1)
    }

    private fun randomLevel(maxLevel: Int): Int {
        if (maxLevel < 0) {
            return 0
        }
        var l = 0
        val random = Random()
        while (random.nextBoolean() && l <= maxLevel) {
            l++
        }
        return l
    }

    /**
     * level: 当前node 的层级,从0开始计算
     */
    class SkipListNode(val `val`: Int, val level: Int) {

        private var nexts = arrayOfNulls<SkipListNode?>(level + 1)

        /**
         * 只有目标 节点 level 在当前 l 有对应层时才添加
         * @param isOverride 使用给定节点覆盖 当前节点第n层指针
         */
        fun initLevel(l: Int, node: SkipListNode?, isOverride: Boolean = false) {
//            当 node 为null时，任何l 都可以
            if (l >= nexts.size || l > node?.level ?: Int.MAX_VALUE) {
                return
            }
            val next = nexts[l]
            nexts[l] = node
            if (!isOverride) {
                node?.initLevel(l, next, true)
            }
        }

        fun hasNext(l: Int): Boolean = l < nexts.size

        fun next(l: Int): SkipListNode? {
            return if (l < nexts.size) {
                nexts[l]
            } else {
                null
            }
        }
    }

    override fun toString(): String {
        val sb = StringBuilder()
        for ((i, v) in head.withIndex()) {
            var cur = v
            sb.append("第$i level: ")
            while (cur != null) {
                sb.append("${cur.`val`} -> ")
                cur = cur.next(i)
            }
            sb.append("\n")

        }
        return sb.toString()
    }
}


/**
 * 传入最小堆，返回整体后最大的元素
 * 传入最大堆，返回整体最小的元素
 * @author wezhyn
 * @since 07.03.2020
 *
 */
class FixedPriorityQueue<T : Comparable<T>>(val queue: PriorityQueue<T>, private val maxSize: Int) : Queue<T> by queue {

    private val comparator = queue.comparator() ?: Comparator.naturalOrder()

    override fun add(element: T): Boolean {
        return this.offer(element)
    }

    override fun offer(e: T): Boolean {

        when {
            queue.size < maxSize -> {
                queue.offer(e)
//            原队列的排序，如果原序列采用的是最小堆，queue.peek()返回的是最小的 ，一步步去除最小的，整体最后是序列的最大值
//            如果是最大堆，peek()返回最大值，一步步去除最大值，整体最小
            }
            comparator.compare(e, queue.peek()) > 0 -> {
                queue.poll()
                queue.offer(e)
            }
            else -> {
                return false
            }
        }
        return true
    }
}