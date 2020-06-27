package com.offer

/**
 *
 * @author wezhyn
 * @since 06.27.2020
 *
 */
class WordSearch {

    companion object {
        val offset = intArrayOf(0, -1, 0, 1, 0)
    }

    fun exist(board: Array<CharArray>, word: String): Boolean {
        for (i in board.indices) {
            for (y in board[i].indices)
                if (board[i][y] == word[0]) {
                    if (backtrack(board, i, y, word, 1)) {
                        return true
                    }
                }
        }
        return false
    }


    private fun backtrack(board: Array<CharArray>, x: Int, y: Int, word: String, index: Int): Boolean {
        val cur = board[x][y]
        board[x][y] = ' '
//        已经将当前字符串全部查找完
        if (index >= word.length) {
            return true
        }
        var result = false
        try {
            for (i in 0..3) {
                val xi = x + offset[i]
                val yi = y + offset[i + 1]
                if (xi < 0 || yi < 0 || xi >= board.size || yi >= board[xi].size) {
                    continue
                }
                if (board[xi][yi] == word[index]) {
                    result = result || backtrack(board, xi, yi, word, index + 1)
                }
            }
            return result
        } finally {
            board[x][y] = cur
        }
    }
}