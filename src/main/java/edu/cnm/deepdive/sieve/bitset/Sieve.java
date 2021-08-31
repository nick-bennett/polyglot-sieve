package edu.cnm.deepdive.sieve.bitset;

import java.util.BitSet;

public class Sieve {

  private static BitSet sieve(int limit) {
    BitSet candidates = new BitSet(limit + 1);
    candidates.set(2, limit + 1);
    for (int prime = 2; prime <= Math.sqrt(limit); prime = candidates.nextSetBit(prime + 1)) {
      for (int multiple = prime * prime; multiple <= limit; multiple += prime) {
        candidates.clear(multiple);
      }
    }
    return candidates;
  }

  public static void main(String... args) {
    int upperBound = 1_000_000;
    long start = System.currentTimeMillis();
    BitSet primes = sieve(upperBound);
    long end = System.currentTimeMillis();
    System.out.printf("Java Sieve with BitSet:%n"
            + "%1$,d primes found between %2$,d and %3$,d in %4$d ms.%n",
        primes.cardinality(), primes.nextSetBit(0), primes.previousSetBit(primes.size() - 1),
        end - start);
  }

}
