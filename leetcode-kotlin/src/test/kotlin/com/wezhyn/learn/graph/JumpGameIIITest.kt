package com.wezhyn.learn.graph

import com.wezhyn.learn.onePrimitiveArray
import org.junit.Test

/**
 * @author wezhyn
 * @since 06.24.2020
 */
class JumpGameIIITest {

    @Test
    fun canReach() {
        JumpGameIII().canReach("4,2,3,0,3,1,2".onePrimitiveArray { it.toInt() }, 5).apply(System.out::println)
//    JumpGameIII().canReach("[4,2,3,0,3,1,2]".oneDimensional().toIntArray(), 0).apply(System.out::println)
//    JumpGameIII().canReach("[3,0,2,1,2]".oneDimensional().toIntArray(), 2).apply(System.out::println)
    }
}