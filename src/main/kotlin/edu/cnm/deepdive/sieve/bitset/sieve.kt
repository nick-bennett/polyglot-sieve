package edu.cnm.deepdive.sieve.bitset

import java.util.BitSet
import java.util.stream.Collectors

fun sieve(limit: Int): List<Int> {
    val primes = BitSet()
    primes.set(2, limit + 1)
    var prime = 2
    while (prime <= Math.sqrt(limit.toDouble()).toInt()) {
        for (multiple in (prime * prime)..limit step prime) {
            primes.clear(multiple)
        }
        prime = primes.nextSetBit(prime + 1)
    }
    return primes.stream().boxed().collect(Collectors.toList())
}

fun main(args: Array<String>) {
    println(sieve(1_000_000))
}