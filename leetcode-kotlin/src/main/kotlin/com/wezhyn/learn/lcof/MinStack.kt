package com.wezhyn.learn.lcof

import java.util.*

/**
 *
 * @author wezhyn
 * @since 06.30.2020
 *
 */
class MinStack {

    private val stack = LinkedList<Int>()
    private val minStack = LinkedList<Int>()

    fun push(x: Int) {
        stack.push(x)
        val peek = minStack.peek()
        if (x < peek) {
            minStack.push(x)
        } else {
            minStack.push(peek)
        }
    }

    fun pop() {
        stack.poll()
        minStack.poll()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }
}