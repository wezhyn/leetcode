package com.wezhyn.learn.graph

import java.util.*

/**
 *
 * @author wezhyn
 * @since 06.22.2020
 *
 */
class KeysAndRooms {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visit = BooleanArray(rooms.size) { false }
        val queue = LinkedList<Int>()
        queue.add(0)
        while (queue.isNotEmpty()) {
            val room = queue.poll()
            if (!visit[room]) {
                visit[room] = true
                rooms[room].forEach {
                    if (!visit[it]) {
                        queue.add(it)
                    }
                }
            }
        }
        for (v in visit) {
            if (!v) {
                return false
            }
        }
        return true
    }
}