package com.wezhyn.learn.dp

/**
 *
 * 为了能够一次打印更多的字符，争取每次打印时，都多打相同的字符
 *
 * Example：
 * input： ababc
 * f(ababc)=Min: (f(a),f(babc)) (f(aba)+f(bc))
 *              (1+Min ( f(b),f(abc) ,f(bab),f(c))  (f(a)+f(b) +f(b)+f(c) =4
 *              (1+ Min(4,3)=4) 4
 *
 *
 * @author wezhyn
 * @since 06.25.2020
 *
 */
class StrangePrinter {
    private lateinit var cache: HashMap<String, Int>
    fun strangePrinter(s: String): Int {
        cache = HashMap()
        return calculate(s)
    }

    private fun calculate(v: String): Int {
//        ""
        if (v.isBlank()) {
            return 0
        }
        var num = cache.getOrDefault(v, Int.MAX_VALUE)
        if (num != Int.MAX_VALUE) {
            return num
        }
        var r = v.length - 1
//        aba 变成 ab
        while (r > 0) {
            if (v[r] == v[0]) {
                r--
            } else {
                break
            }
        }
//        即 aaa ,a
        if (r == 0) {
            return 1
        }
        for (li in 0..r) {
            if (v[li] == v[0]) {
                num = Math.min(num, calculate(v.substring(0, li + 1)) + calculate(v.substring(li + 1, r + 1)))
            }
        }
        cache[v] = num
        return num
    }

}