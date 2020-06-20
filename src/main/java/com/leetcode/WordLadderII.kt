package com.leetcode

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/**
 *
 * @author wezhyn
 * @since 06.19.2020
 *
 */
class WordLadderII {
    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        val map = HashSet<String>(wordList)
        if (!map.contains(endWord)) {
            return emptyList()
        }
        val useWord = HashMap<String, Int>()
        val head = Node(beginWord, null)
        val end = Node(endWord, null)
        val searchQueue = LinkedList<Node>().apply { offer(head) }
        while (searchQueue.isNotEmpty() && map.size > 0) {
            val cur = searchQueue.poll()
            for (i in cur.str.indices) {
                val strChars = cur.str.toCharArray()
                for (c in 'a'..'z') {
                    strChars[i] = c
                    val convertStr = String(strChars)
                    if (map.contains(convertStr)) {
                        if (convertStr == endWord) {
                            cur.childs.add(end)
                            continue
                        }
                        val nodeLevel = useWord.getOrPut(convertStr) { cur.level + 1 }
                        if (nodeLevel > cur.level) {
                            val newNode = Node(convertStr, cur)
                            cur.childs.add(newNode)
                            searchQueue.add(newNode)
                        }
                    }
                }
            }
        }
        return bfs(head, end)
    }

    private fun bfs(head: Node, end: Node): List<List<String>> {
        val queue = LinkedList<Node>().apply { offer(head) }
        val result = ArrayList<ArrayList<String>>()
        var minLength = Int.MAX_VALUE
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node.childs.contains(end)) {
                val nodeList = ArrayList(node.print()).apply { add(end.str) }
                if (nodeList.size < minLength) {
                    result.clear()
                    minLength = nodeList.size
                }
                if (nodeList.size == minLength) {
                    result.add(nodeList)
                }
            } else {
                queue.addAll(node.childs)
            }
        }
        return result
    }

    private fun Node.print(): List<String> {
        val result = ArrayList<String>()
        var cur = this
        while (cur != cur.parent) {
            result.add(cur.str)
            cur = cur.parent
        }
        result.add(cur.str)
        return result.reversed()
    }


    //        每一个节点一定有父节点
    class Node(val str: String) {
        lateinit var parent: Node
        var level = 1
        val childs = ArrayList<Node>()

        constructor(str: String, parent: Node?) : this(str) {
            this.parent = parent ?: this
            if (parent != null) {
                this.level = parent.level + 1
            }
        }
    }
}