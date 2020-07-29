package com.leetcode.algorithm

import com.leetcode.dp.limited.Triangle
import com.twoList
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.23.2020
 */
class TriangleTest {

    @Test
    fun minimumTotal() {
        assertEquals(0, Triangle().minimumTotal("""  []""".twoList { it.toInt() }))
        assertEquals(2, Triangle().minimumTotal("""  [2]""".twoList { it.toInt() }))
        assertEquals(5, Triangle().minimumTotal("""  [2], [3,4]""".twoList { it.toInt() }))
        assertEquals(11, Triangle().minimumTotal("""  [2], [3,4], [6,5,7], [4,1,8,3]""".twoList { it.toInt() }))
    }
}