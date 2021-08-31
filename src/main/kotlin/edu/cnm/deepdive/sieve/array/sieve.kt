package edu.cnm.deepdive.sieve.array

import kotlin.math.sqrt

fun sieve(limit: Int): List<Int> {
    val primes = mutableListOf<Int>()
    if (limit >= 2) {
        val candidates = BooleanArray(2) { false } + BooleanArray(limit - 1) { true }
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
    val start = System.currentTimeMillis()
    val upperBound = 1_000_000
    val primes = sieve(upperBound)
    val end = System.currentTimeMillis()
    println(
        """
            Kotlin Sieve with BooleanArray and List<Int>: 
            ${primes.size} primes found between ${primes.first()} and ${primes.last()} in ${end - start} ms.
        """.trimIndent()
    )
}