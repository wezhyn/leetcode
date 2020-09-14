package com.wezhyn.learn.daily

/**
 *We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
 *
 * Input: "USA"
 * Output: true
 * Input: "FlaG"
 * Output: false
 * @author wezhyn
 * @since 08.18.2020
 *
 */
class DetectCapital {

    fun detectCapitalUse(word: String): Boolean {
        var capitalNum = 0
        for (s in word) {
            if (s.isUpperCase()) {
                capitalNum++
            }
        }
        return when (capitalNum) {
            0 -> true
            1 -> word.isNotEmpty() && word[0].isUpperCase()
            word.length -> true
            else -> false
        }

    }

}