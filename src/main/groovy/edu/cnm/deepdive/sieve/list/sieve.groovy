package edu.cnm.deepdive.sieve.list

static def sieve(int limit) {
    def candidates = [false] * 2 + [true] * (limit - 1)
    (2..(Math.sqrt(limit)).intValue()).each { value ->
        if (candidates[value]) {
            ((value**2)..limit).step(value) {
                candidates[it] = false
            }
        }
    }
    (0..limit).findAll {
        candidates[it]
    }
}

def start = System.currentTimeMillis()
def upperBound = 1_000_000
def primes = sieve(upperBound)
def end = System.currentTimeMillis()
println("""\
    Groovy Sieve with List<Boolean> and List<Integer>: 
    ${primes.size()} primes found between ${primes.first()} and ${primes.last()} (inclusive) in ${end - start} ms.
    """.stripIndent())