package edu.cnm.deepdive.sieve.list

static List sieve(limit) {
    def primes = [false] * 2 + [true] * (limit - 1)
    (2..(Math.sqrt(limit)).intValue()).each { value ->
        if (primes[value]) {
            ((value**2)..limit).step(value) {
                primes[it] = false
            }
        }
    }
    (0..limit).findAll {
        primes[it]
    }
}

println(sieve(1_000_000))
