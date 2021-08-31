package edu.cnm.deepdive.sieve.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Sieve {

  private static int[] sieve(int limit) {
    boolean[] candidates = new boolean[limit + 1];
    Arrays.fill(candidates, 2, limit + 1, true);
    for (int value = 2; value <= Math.sqrt(limit); value++) {
      if (candidates[value]) {
        for (int multiple = value * value; multiple <= limit; multiple += value) {
          candidates[multiple] = false;
        }
      }
    }
    return IntStream
        .range(0, candidates.length)
        .filter((value) -> candidates[value])
        .toArray();
  }

  public static void main(String... args) {
    int upperBound = 1_000_000;
    long start = System.currentTimeMillis();
    int[] primes = sieve(upperBound);
    long end = System.currentTimeMillis();
    System.out.printf("Java Sieve with boolean[] and int[]:%n"
            + "%1$,d primes found between %2$,d and %3$,d in %4$d ms.%n",
        primes.length, primes[0], primes[primes.length - 1], end - start);
  }

}
