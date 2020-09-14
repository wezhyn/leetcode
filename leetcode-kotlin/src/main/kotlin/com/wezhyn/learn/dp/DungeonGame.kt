package com.wezhyn.learn.dp

/**
 *
 *
 * @author wezhyn
 * @since 06.23.2020
 *
 */
class DungeonGame {
    companion object {
        val moveOffset = intArrayOf(0, 1, 0)
    }

    fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
        val lastRowIndex = dungeon.size - 1
//        当前骑士最小血量
        if (lastRowIndex < 0 || dungeon.isEmpty()) {
            return 1
        }
        if (lastRowIndex == 0) {
            when (dungeon[0].size) {
                1 -> return if (dungeon[0][0] < 0) 1 + Math.abs(dungeon[0][0]) else 1
                0 -> return 1
            }
        }
        val dp = Array(dungeon.size) { IntArray(dungeon[it].size) { 1 } }
        for (x in lastRowIndex downTo 0) {
            val lastColumnIndex = dungeon[x].size - 1
            for (y in lastColumnIndex downTo 0) {
                var min = Int.MAX_VALUE
//                向左走，向右走
                for (mi in 0..1) {
                    val xi = x + moveOffset[mi]
                    val yi = y + moveOffset[mi + 1]
                    if (xi < 0 || yi < 0 || xi > lastRowIndex || yi >= dungeon[xi].size) {
//                        无效
                        continue
                    }
                    min = Math.min(min, dp[xi][yi])
                }
                if (min == Int.MAX_VALUE) {
//                    最后一个元素
                    min = 1
                }
                dp[x][y] = if (min - dungeon[x][y] <= 0) 1 else min - dungeon[x][y]
            }
        }
        return dp[0][0]
    }
}