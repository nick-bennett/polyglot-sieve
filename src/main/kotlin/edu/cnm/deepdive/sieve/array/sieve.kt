package edu.cnm.deepdive.sieve.array

import kotlin.math.sqrt

fun sieve(limit: Int): List<Int> {
    val primes = mutableListOf<Int>()
    if (limit >= 2) {
        val candidates = Array(2) { false } + Array(limit - 1) { true }
        for (factor in 2..sqrt(limit.toDouble()).toInt()) {
            if (candidates[factor]) {
                for (multiple in (factor * factor)..limit step factor) {
                    candidates[multiple] = false
                }
            }
        }
        candidates.forEachIndexed { number, isPrime ->
            if (isPrime) {
                primes.add(number)
            }
        }
    }
    return primes
}

fun main(args: Array<String>) {
    println(sieve(1_000_000))
}