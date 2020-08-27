package com.offer

/**
 * 题目： 给一个n 求 1.. n 中 1出现的次数
 * 思路：划分区间
 * 假设 n = 12X4
 *
 * 当十位为3时 即  1234， 有   [[1x] ,[ x1x], [ xx1x]] 有 10 +12*10=130
 * 当十位为1时，即 1214  [[10,11,12,13,14] ,[ x1x], [ xx1x]] 有 5 +11*10=115
 * 当十位为0时，即 1204 有 [ x1x ],[ xx1x] 即 11 * 10 =110
 *
 * 每一位的划分需要考虑 0,1,other 三种情况
 *
 * @author wezhyn
 * @since 07.09.2020
 *
 */
class NumberOfDigitOne {
    fun countDigitOne(n: Int): Int {
//        将数字划分成三段， h cur l -> h: cur之前的数字， cur 当前选择的位置， l: 低位数字
//        则 l= cur * 对应pow(10,位数) 个位：0，十位1 则 digit 表示 pow(10,位数)
        var h = n / 10
        var cur = n % 10
        var l = 0
        var digit = 1
        var result = 0
        while (h != 0 || cur != 0) {
            result += when (cur) {
                //                101  -> 1X
                0 -> {
                    h * digit
                }
                1 -> {
                    //                    11l -> 110->11l + 1x
                    h * digit + l + 1
                }
                else -> {
                    //                    121 -> 11x 01x
                    (h + 1) * digit
                }
            }
            l += cur * digit
            cur = h % 10
            h /= 10
            digit *= 10
        }
        return result
    }


}