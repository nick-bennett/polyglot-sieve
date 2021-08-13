package edu.cnm.deepdive.sieve.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sieve {

  private static List<Integer> sieve(int limit) {
    boolean[] flags = new boolean[limit + 1];
    List<Integer> primes = new LinkedList<>();
    Arrays.fill(flags, 2, limit + 1, true);
    for (int value = 2; value <= Math.sqrt(limit); value++) {
      if (flags[value]) {
        for (int multiple = value * value; multiple <= limit; multiple += value) {
          flags[multiple] = false;
        }
      }
    }
    for (int value = 0; value <= limit; value++) {
      if (flags[value]) {
        primes.add(value);
      }
    }
    return primes;
  }

  public static void main(String... args) {
    int upperBound = 1_000_000;
    long start = System.currentTimeMillis();
    List<Integer> primes = sieve(upperBound);
    long end = System.currentTimeMillis();
    System.out.printf("Java Sieve with boolean[] and List<Integer>:%n"
        + "%1$,d primes found between 2 and %2$,d in %3$d ms.%n",
        primes.size(), upperBound, end - start);
  }

}
