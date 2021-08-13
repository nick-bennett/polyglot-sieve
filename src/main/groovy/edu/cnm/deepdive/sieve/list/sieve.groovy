package edu.cnm.deepdive.sieve.list

static List<Integer> sieve(int limit) {
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

def start = System.currentTimeMillis()
def upperBound = 1_000_000
def primes = sieve(upperBound)
def end = System.currentTimeMillis()
println(
    """\
        Groovy Sieve with Lists: 
        ${primes.size()} primes found between 2 and $upperBound in ${end - start} ms.
    """.stripIndent()
)