package edu.cnm.deepdive.sieve.bitset

import java.util.BitSet

fun sieve(limit: Int): BitSet {
    val primes = BitSet()
    primes.set(2, limit + 1)
    var prime = 2
    while (prime <= Math.sqrt(limit.toDouble()).toInt()) {
        for (multiple in (prime * prime)..limit step prime) {
            primes.clear(multiple)
        }
        prime = primes.nextSetBit(prime + 1)
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
            Kotlin Sieve with BitSet: 
            ${primes.cardinality()} primes found between ${primes.nextSetBit(0)} and ${primes.previousSetBit(primes.size() - 1)} (inclusive) in ${end - start} ms.
        """.trimIndent()
    )
}