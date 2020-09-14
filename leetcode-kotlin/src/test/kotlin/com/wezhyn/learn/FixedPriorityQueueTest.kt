package com.wezhyn.learn

import org.junit.Test
import java.util.*

/**
 * @author wezhyn
 * @since 07.03.2020
 */
class FixedPriorityQueueTest {

    @Test
    fun test() {
        val queue = FixedPriorityQueue<Int>(PriorityQueue(), 4)
        generateSequence { Random().nextInt(1000) }
                .take(20)
                .iterator()
                .forEach {
                    print("${it}\t")
                    queue.offer(it)
                }
        println()
        for (i in queue) {
            print("${i}\t")
        }
    }

}
