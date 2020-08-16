package com.daily

/**
 *Input:
board = [
['o','a','a','n'],
['e','t','a','e'],
['i','h','k','r'],
['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]
 * @author wezhyn
 * @since 08.16.2020
 *
 */
class WordSearchII {

    companion object {
        private val offset = intArrayOf(1, 0, -1, 0, 1)
    }

    private lateinit var visits: Array<BooleanArray>

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val cache = HashMap<Char, MutableList<Pair<Int, Int>>>()
        visits = Array(board.size) { i -> BooleanArray(board[i].size) }
        board.forEachIndexed { x, chars ->
            chars.forEachIndexed { y, c ->
                cache.getOrPut(c) { ArrayList() }.add(Pair(x, y))
            }
        }
        return words.asSequence()
                .filter { it.isNotEmpty() }
                .filter {
                    val pairs = cache[it[0]] ?: return@filter false
                    var result = false
                    for (p in pairs) {
                        result = result.or(backtracking(board, p.first, p.second, it, 1))
                        if (result) {
                            break
                        }
                    }
                    result
                }
                .toList()

    }

    private fun backtracking(board: Array<CharArray>, i: Int, j: Int, str: String, index: Int): Boolean {
        if (index == str.length) {
            return true
        }
        var result = false
        try {
            visits[i][j] = true
            for (k in 0..3) {
                if (result) break
                val x = i + offset[k]
                val y = j + offset[k + 1]
                if (x < 0 || y < 0 || x >= board.size || y >= board[x].size) {
                    continue
                }
                if (!visits[x][y] && board[x][y] == str[index]) {
                    result = result.or(backtracking(board, x, y, str, index + 1))
                }
            }
        } finally {
            visits[i][j] = false
        }
        return result
    }
}