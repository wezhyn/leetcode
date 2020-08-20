package com.random

/**
 *
 * @author wezhyn
 * @since 08.20.2020
 *
 */
class GoatLatin {

    fun toGoatLatin(S: String): String {
        val strs = S.split(" ").filter { it.isNotBlank() }
        val sb = StringBuilder()
        for ((i, v) in strs.withIndex()) {
            sb.append(latin(v, i))
            if (i != strs.size - 1) {
                sb.append(" ")
            }
        }
        return sb.toString()
    }

    private fun latin(word: String, index: Int): String {
        if (word.isBlank()) {
            return ""
        }
        val sb = StringBuilder()
        for (ci in 1 until word.length) {
            sb.append(word[ci])
        }
        when (val firstChar = word[0].toLowerCase()) {
            'a', 'e', 'i', 'o', 'u' -> {
                sb.insert(0, word[0])
                sb.append("ma")
            }
            else -> {
                sb.append(word[0]).append("ma")
            }
        }
        repeat(index + 1) { sb.append("a") }
        return sb.toString()
    }
}