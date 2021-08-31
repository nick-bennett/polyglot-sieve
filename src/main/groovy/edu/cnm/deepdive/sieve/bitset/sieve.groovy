package edu.cnm.deepdive.sieve.bitset

static def sieve(int limit) {
    def candidates = new BitSet(limit + 1)
    candidates[0..1] = false
    candidates[2..limit] = true
    def prime = candidates.nextSetBit(0)
    while (prime <= Math.sqrt(limit)) {
        ((prime**2)..limit).step(prime) {
            candidates[it] = false
        }
        prime = candidates.nextSetBit(prime + 1)
    }
    return candidates
}

def start = System.currentTimeMillis()
def upperBound = 1_000_000
def primes = sieve(upperBound)
def end = System.currentTimeMillis()
println("""\
    Groovy Sieve with BitSet: 
    ${primes.cardinality()} primes found between ${primes.nextSetBit(0)} and ${primes.previousSetBit(primes.size() - 1)} (inclusive) in ${end - start} ms.
    """.stripIndent())