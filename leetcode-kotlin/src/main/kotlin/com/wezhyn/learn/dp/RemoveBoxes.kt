package com.wezhyn.learn.dp

/**
 *Given several boxes with different colors represented by different positive numbers.
 * You may experience several rounds to remove boxes until there is no box left.
 * Each time you can choose some continuous boxes with the same color (composed of k boxes, k >= 1), remove them and get `k*k` points
 * Find the maximum points you can get.
 **Example 1:**
```
Input: boxes = [1,3,2,2,2,3,4,3,1]
Output: 23
Explanation:
[1, 3, 2, 2, 2, 3, 4, 3, 1]
----> [1, 3, 3, 4, 3, 1] (3*3=9 points)
----> [1, 3, 3, 3, 1] (1*1=1 points)
----> [1, 1] (3*3=9 points)
----> [] (2*2=4 points)
```

 * 尝试一： 失败，超时
 * 为了获取更多的分数，需要在每一轮匹配时尽可能的使用相同的元素，每一轮时，选中的元素被保留，删除这之间的元素，使得这些被我们选中的元素
 * 能够连续起来 ，例如 1122122 ，1的划分有如下几种 11 22 1 22
 * 保留第一个11 剩余 22122 -> 2*2+ 22122
 * 保留第二个1 剩下 11 2222 -> 1 + 11 2222
 * 保留全部1 ，22 22 -> 2*2+1 + 22 22
 * 缺少如下条件：
 * 删除11 或者 1 或者 1
 * 删除11 4 + 22122
 * 删除 1 1 + 112222
 *
 *
 *
 * @see StrangePrinter
 * @author wezhyn
 * @since 07.23.2020
 *
 */
class RemoveBoxes {
    private lateinit var cache: HashMap<String, Int>

    fun removeBoxes(boxes: IntArray): Int {
        cache = HashMap()
//        某一个数其重复次数
        return dp(boxes.map { it.toChar() }
                .joinToString(separator = ""))
    }

    private fun dp(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }
        var num = cache.getOrDefault(s, Int.MIN_VALUE)
        if (num != Int.MIN_VALUE) {
            return num
        }
        var l = 0
        while (l < s.length && l != -1) {
            var nextL = l
//                删除 a
            num = Math.max(num, dpRemove(s, l, maxSegment(s, l)))
            while (nextL < s.length && nextL != -1) {
                nextL = maxSegment(s, nextL)
                num = Math.max(num, dpRemain(s, l, nextL))
                nextL = s.indexOf(s[0], nextL + 1)
            }
            l = s.indexOf(s[l], maxSegment(s, l) + 1)
        }
        cache[s] = num
        return num
    }

    private fun dpRemove(s: String, l: Int, nextL: Int): Int {
//                删除 a
        var tmpNum = Math.pow((nextL - l + 1).toDouble(), 2.0).toInt()
        tmpNum += dp(s.substring(0, l) + s.substring(nextL + 1))
        return tmpNum
    }

    private fun dpRemain(s: String, l: Int, nextL: Int): Int {
//                保留 a
        val clearPair = clearStr(s, l, nextL)
        var tmpNum = Math.pow(clearPair.second.toDouble(), 2.0).toInt()
        for (cs in clearPair.first) {
            tmpNum += dp(cs)
        }
        return tmpNum
    }

    /**
     * 清除 s[l-r] 范围内字符串等于c的字符
     * ababa 清除 a return {b}{b} {2}
     */
    private fun clearStr(s: String, l: Int, r: Int): Pair<List<String>, Int> {
        val c = s[l]
        val resultStr = ArrayList<String>()
        var clearNum = 0
        val subStr = s.substring(l, r + 1)
        for (cs in subStr) {
            if (cs == subStr[0]) {
                clearNum++
            }
        }
        subStr.split(s[0])
                .asSequence()
                .filter { it.isNotEmpty() }
                .toCollection(resultStr)
        s.substring(0, l).apply { if (this.isNotEmpty()) resultStr.add(this) }
        s.substring(r + 1, s.length).apply { if (this.isNotEmpty()) resultStr.add(this) }
        return return Pair(resultStr, clearNum)
    }

    /**
     * 返回某一段相同字符的最后一个索引
     * 例如 maxSegment("aaba",0) 返回aaa这一段a的最后一个索引
     * maxSegment("aaaba",4) 返回a这一段a的最后一个索引
     */
    fun maxSegment(s: String, l: Int): Int {
        for (li in l + 1 until s.length) {
            if (s[li] != s[l]) {
                return li - 1
            }
        }
        return s.length - 1
    }

}