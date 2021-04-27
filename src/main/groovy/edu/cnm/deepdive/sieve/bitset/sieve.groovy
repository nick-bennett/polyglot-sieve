package edu.cnm.deepdive.sieve.bitset

static List sieve(int limit) {
    def primes = new BitSet(limit + 1)
    primes[0..1] = false
    primes[2..limit] = true
    def prime = 2
    while (prime <= Math.sqrt(limit)) {
        ((prime**2)..limit).step(prime) {
            primes[it] = false
        }
        prime = primes.nextSetBit(prime + 1)
    }
    (0..limit).findAll {
        primes[it]
    }
}

println(sieve(1_000_000))