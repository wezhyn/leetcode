package com.wezhyn.learn.lcof

import java.util.*

/**
 *
 * @author wezhyn
 * @since 06.30.2020
 *
 */
class ValidateStackSequences {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        if (pushed.isEmpty() && popped.isEmpty()) {
            return true
        } else if (pushed.isEmpty() || popped.isEmpty()) {
            return false
        }
        val stack = LinkedList<Int>()
        var popIndex = 0
        var pushIndex = 0
        while (popIndex < popped.size && pushIndex <= pushed.size) {
            val pop = popped[popIndex]
            if (pop != stack.peek()) {
                if (pushIndex >= pushed.size) {
                    break
                }
                stack.push(pushed[pushIndex++])
            } else {
                stack.poll()
                popIndex++
            }
        }
        if (popIndex < popped.size) {
            return false
        }
        return true
    }
}