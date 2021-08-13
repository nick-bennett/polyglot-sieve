package edu.cnm.deepdive.sieve.bitset

import java.util.BitSet

fun sieve(limit: Int): IntArray {
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
        .stream()
        .toArray()
}

fun main(args: Array<String>) {
    val start = System.currentTimeMillis()
    val upperBound = 1_000_000
    val primes = edu.cnm.deepdive.sieve.array.sieve(upperBound)
    val end = System.currentTimeMillis()
    println(
        """
            Kotlin Sieve with BitSet and IntArray: 
            ${primes.size} primes found between 2 and $upperBound in ${end - start} ms.
        """.trimIndent()
    )
}