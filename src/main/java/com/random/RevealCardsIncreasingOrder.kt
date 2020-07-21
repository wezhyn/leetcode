package com.random

import java.util.*

/**
 *
 * @author wezhyn
 * @since 07.20.2020
 *
 */
class RevealCardsIncreasingOrder {
    fun deckRevealedIncreasing(deck: IntArray): IntArray {
        deck.sortDescending()
        val deque = LinkedList<Int>()
        for (v in deck) {
            if (deque.isNotEmpty()) {
                deque.addFirst(deque.removeLast())
            }
            deque.addFirst(v)
        }
        return deque.toIntArray()
    }
}