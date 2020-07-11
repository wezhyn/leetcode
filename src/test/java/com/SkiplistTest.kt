package com

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.random.Random

/**
 * @author wezhyn
 * @since 07.08.2020
 */
class SkiplistTest {
    @Test
    fun test1() {
        val skip = Skiplist()
        val operateList = """"
            add","add","add","add","add","erase","erase","add","search","search","add","erase","search","add","add","add","erase","search","erase","search","search","search","erase","erase","search","erase","add","add","erase","add","search","search","search","search","search"
        """.oneList { it.trim().substring(1, it.length - 1).trim() }
        val valueList = """
            [9],[4],[5],[6],[9],[2],[1],[2],[7],[4],[5],[6],[5],[6],[7],[4],[3],[6],[3],[4],[3],[8],[7],[6],[7],[4],[1],[6],[3],[4],[7],[6],[1],[0],[3]
        """.oneList { it.substring(1, it.length - 1).toInt() }

        for (i in valueList.indices) {
            val method = Skiplist::class.java.getDeclaredMethod(operateList[i], Int::class.java)
            method.isAccessible = true
            method.invoke(skip, valueList[i])
        }
        println(skip)
    }


    @Test
    fun erase() {
        val skip = Skiplist()
        val list = ArrayList<Int>()
        val random = Random(System.currentTimeMillis())
        for (j in 1..1000) {
            val i = random.nextInt(2000)
            list.add(i)
            skip.add(i)
        }
        val iterator = list.iterator()
        while (iterator.hasNext()) {
            val j = iterator.next()
            val i = random.nextInt(2000)
            assertEquals("$i", list.contains(i), skip.search(i))
            assertTrue("$j", skip.erase(j))
            iterator.remove()
            println(skip)
        }
    }

    @Test
    fun search() {
        val skip = Skiplist()
        val set = HashSet<Int>()
        val random = Random(System.currentTimeMillis())
        for (j in 1..100) {
            val i = random.nextInt(2000)
            set.add(i)
            skip.add(i)
        }
        println(skip)
        for (j in set) {
            val i = random.nextInt(2000)
            assertEquals("$i", set.contains(i), skip.search(i))
            assertEquals("$j", set.contains(j), skip.search(j))
        }
    }

    @Test
    fun add() {
        val skip = Skiplist()
        val random = Random(System.currentTimeMillis())
        for (i in 1..20) {
            skip.add(random.nextInt(100))
        }
        println(skip)
    }

}