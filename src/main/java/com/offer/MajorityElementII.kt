package com.offer

/**
 * 由于每个重复元素超过1/3 ，所以使用++ -- 最后该元素仍然是 >0
 * 使用方法四进行求解
 * @see MajorityElement
 * @author wezhyn
 * @since 07.02.2020
 *
 */
class MajorityElementII {
    fun majorityElement(nums: IntArray): List<Int> {
        val x = Pair(0, 0)
        val y = Pair(0, 0)
        for (v in nums) {
            when {
                x.times == 0 -> {
                    if (y.num != v) {
                        x.num = v
                    }
                }
                y.times == 0 -> {
                    if (x.num != v) {
                        y.num = v
                    }
                }
            }
            when (v) {
                x.num -> {
                    x.times++
                }
                y.num -> {
                    y.times++
                }
                else -> {
                    x.times--
                    y.times--
                }
            }
        }
        x.times = 0
        y.times = 0
        for (v in nums) {
            when (v) {
                x.num -> x.times++
                y.num -> y.times++
            }
        }

        return ArrayList<Int>().apply {
            if (x.times > nums.size / 3) {
                this.add(x.num)
            }
            if (y.times > nums.size / 3) {
                this.add(y.num)
            }
        }
    }

    private class Pair(var num: Int, var times: Int)

}




