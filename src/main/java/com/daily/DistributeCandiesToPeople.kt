package com.daily

/**
 * 预先分配能分配的全部，在开始分配不足
 * 假设第 x 轮
 * 第一轮需要 1+2+3+..n -> (1+n)*n/2
 * 第二轮 1+2+3+..n + n(x-1)*n -> n*n(x-1)+(1+n)*n/2
 *
 * 即完整分配第x 轮 [1*x+x(x-1)*n/2]
 *
 * @author wezhyn
 * @since 08.18.2020
 *
 */
class DistributeCandiesToPeople {

    fun distributeCandies(_candies: Int, num_people: Int): IntArray {
        var round = 1
        var isEnd = false
        var candies = _candies
        do {
            val nextCandies = roundDistribute(round, num_people)
            if (candies > nextCandies) {
                candies -= nextCandies
                round++
            } else {
                isEnd = true
            }
        } while (!isEnd)
        val distributes = IntArray(num_people) { (it + 1) * (round - 1) + (round - 1) * (round - 2) * num_people / 2 }
        for (i in distributes.indices) {
            val nextPeople = nextPeople(round, num_people, i + 1)
            if (candies > nextPeople) {
                distributes[i] += nextPeople
                candies -= nextPeople
            } else {
                distributes[i] += candies
                break
            }
        }
        return distributes
    }

    private fun nextPeople(round: Int, num: Int, index: Int): Int = index + (round - 1) * num

    //    round from 1
    private

    fun roundDistribute(round: Int, num: Int): Int = num * num * (round - 1) + (1 + num) * num / 2

}