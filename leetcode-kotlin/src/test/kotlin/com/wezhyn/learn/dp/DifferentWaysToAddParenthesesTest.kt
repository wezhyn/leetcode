package com.wezhyn.learn.dp

import com.wezhyn.learn.oneList
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.24.2020
 */
class DifferentWaysToAddParenthesesTest {

    @Test
    fun diffWaysToCompute() {
        assertEquals("-12".oneList() { it.toInt() }, DifferentWaysToAddParentheses().diffWaysToCompute(
                "-11-1"
        ))
        assertEquals("-10".oneList() { it.toInt() }, DifferentWaysToAddParentheses().diffWaysToCompute(
                "-11+1"
        ))
    }
}