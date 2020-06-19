package com.leetcode

import java.util.*
import kotlin.collections.HashSet

/**
 *
 * 根据字典中存在的单词，将给定的 beginWord 转变成 endWord
 *
 *
 * bfs 广度搜索单词
 * 每一轮改变beginWord 中的某一个字符，判断其是否在字典中，获取所有的可能性，然后开始下一轮
 *
 * @author wezhyn
 * @since 06.19.2020
 *
 */
class WordLadder {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val map = HashSet<String>(wordList)
        if (!map.contains(endWord)) {
            return 0
        }
        val searchQueue = LinkedList<Pair<String, Int>>().apply { add(Pair(beginWord, 1)) }
        while (searchQueue.isNotEmpty()) {
            val cur = searchQueue.poll()
            for (i in cur.first.indices) {
//                广度搜索可能的解
                val tryStr = cur.first.toCharArray()
                for (c in 'a'..'z') {
                    tryStr[i] = c
                    val str = String(tryStr)
                    if (map.contains(str)) {
                        if (str.equals(endWord)) {
                            return cur.second + 1
                        }
                        map.remove(str)
                        searchQueue.add(Pair(str, cur.second + 1))
                    }
                }
            }
        }
        return 0
    }
}