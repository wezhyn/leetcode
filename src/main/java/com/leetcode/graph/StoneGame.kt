package com.leetcode.graph

/**
 *
 * Alex and Lee play a game with piles of stones.
 * There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
 *The objective of the game is to end with the most stones.
 * The total number of stones is odd, so there are no ties.
 * Alex and Lee take turns, with Alex starting first.
 * Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.
 * This continues until there are no more piles left, at which point the person with the most stones wins.
 * Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
 *
 * 为了赢得对手，获取总体最大值，需要递归获取最佳选择
 * Example 1：
 * [3,3,10,5]
 * A: 3 10
 * B: 3 5
 * 所以无法根据开头与结尾的最佳值来判断，需要权衡，故而需要递归查找，典型的Min-Max题型
 * 如果在递归过程中获取当前的最佳值，需要保存 Alex 最佳与 Lee最佳，而使用两者之间的差值，只需要保存一个变量
 * 每个玩家的最佳值= f(选择的位置) - f(对手：剩余位置的最佳值与之后自身的最佳值)
 *
 * 当位于 3,4时， 我当前最佳能比对手多1 ，即 4
 * 当位于 3,4,3时，我取第一个3，对手最佳比我多1，我拿完3后，比对手多2，最后一个同比
 * 当位于 5，3，4，3时，我选取第一个5，对手比我多2，-2 比对手对3 ，我选3，对手最佳 比我多4，此时-1，所以选择5
 *
 *
 *
 * @author wezhyn
 * @since 06.16.2020
 *
 */
class StoneGame {

    // -1 代表还未查询过
    private lateinit var map: Array<IntArray>
    fun stoneGame(piles: IntArray): Boolean {
        map = Array(piles.size) { IntArray(piles.size) { Int.MIN_VALUE } }

        return offset(piles, 0, piles.size - 1) > 0
    }


    private fun offset(piles: IntArray, l: Int, r: Int): Int {
        if (map[l][r] > Int.MIN_VALUE) {
            return map[l][r]
        }
        if (l == r) {
//            只有当前选手能选
            return piles[l]
        }

        val max = Math.max(
                piles[l] - offset(piles, l + 1, r),
                piles[r] - offset(piles, l, r - 1)
        )
        map[l][r] = max
        return max
    }
}

