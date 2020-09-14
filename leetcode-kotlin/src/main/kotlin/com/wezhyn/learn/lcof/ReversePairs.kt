package com.wezhyn.learn.lcof

/**
 *
 * 虽然是模拟 归并排序的归并过程，但需要添加一个新的步骤
 * 假设 左数组为 [2,4] 右数组[1,3,5]
 * 正常的归并过程只检查了 2 和 1 的比较，这时就会造成不满足 nums[left]>2*nums[right] 需要 left 左移查找到第一个满足的元素
 *
 * 第一次提交：未考虑 正负数
 *
 * @author wezhyn
 * @since 07.14.2020
 *
 * Note:
 * 1.  The length of the given array will not exceed `50,000`.
 * 2.  All the numbers in the input array are in the range of 32-bit integer.
 */
class ReversePairs {
    fun reversePairs(nums: IntArray): Int {
        return merge(nums, 0, nums.size - 1)
    }

    /**
     * @return 逆序对个数
     */
    private fun merge(nums: IntArray, l: Int, r: Int): Int {
        if (l >= r) {
            return 0
        }
        val middle = (l + r + 1).shr(1)
        var result = 0
        result += merge(nums, l, middle - 1)
        result += merge(nums, middle, r)
        var ri = middle
        for (li in l until middle) {
            while (ri <= r && compareReversePair(nums[li], nums[ri])) {
                ri++
            }
            result += ri - middle
        }
        doMerge(nums, l, middle, r)
        return result
    }

    private fun doMerge(nums: IntArray, l: Int, m: Int, r: Int) {
        if (l >= r) return
        val copy = nums.copyOfRange(l, r + 1)
//        [l,middle) ,[middle,r]
        var li = 0
        val middle = m - l
        var ri = middle
        for (i in l..r) {
            val lNum = if (li >= middle) Int.MAX_VALUE else copy[li]
            val rNum = if (l + ri > r) Int.MAX_VALUE else copy[ri]
            if (lNum <= rNum && li < middle) {
                nums[i] = lNum
                li++
            } else {
                nums[i] = rNum
                ri++
            }
        }
    }


    private fun compareReversePair(lNum: Int, rNum: Int): Boolean {
        return lNum.toDouble().div(2).compareTo(rNum) > 0
    }
}