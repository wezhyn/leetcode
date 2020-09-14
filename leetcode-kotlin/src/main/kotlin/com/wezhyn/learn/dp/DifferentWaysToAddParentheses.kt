package com.wezhyn.learn.dp

/**
 * 一个 () 可以看作一次方法调用
 * @author wezhyn
 * @since 06.24.2020
 *
 */
class DifferentWaysToAddParentheses {

    companion object {
        val operations = arrayListOf(Pair('+', { s1: Int, s2: Int -> s1 + s2 }),
                Pair('-', { s1: Int, s2: Int -> s1 - s2 }),
                Pair('*', { s1: Int, s2: Int -> s1 * s2 }))
    }

    private lateinit var result: MutableList<Int>
    private lateinit var map: MutableMap<String, List<Int>>
    fun diffWaysToCompute(input: String): List<Int> {
        result = ArrayList()
        map = HashMap()
        return dp(input)
    }


    private fun dp(input: String): List<Int> {
        if (map.contains(input)) {
            return map.getOrDefault(input, emptyList())
        }
        val result = ArrayList<Int>()
        for (i in input.indices) {
            val c = input[i]
            val ope = operations.find { it.first == c }
            if (ope != null) {
                val left = input.substring(0, i)
                val right = input.substring(i + 1)
                val leftResult = dp(left.trim())
                val rightResult = dp(right.trim())
                leftResult.forEach { a ->
                    rightResult.forEach { b -> result.add(ope.second(a, b)) }
                }
            }
        }
        if (result.isEmpty() && input.isNotBlank()) {
            result.add(input.toInt())
        }
        map[input] = result
        return result
    }
}