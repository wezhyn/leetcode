package com.leetcode.dp

import com.leetcode.dp.limited.DominoAndTrominoTiling
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author wezhyn
 * @since 07.24.2020
 */
class DominoAndTrominoTilingTest {

    @Test
    fun numTilings() {
        assertEquals(5, DominoAndTrominoTiling().numTilings(3))
        assertEquals(979232805, DominoAndTrominoTiling().numTilings(1000))
    }
}