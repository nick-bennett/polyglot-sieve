package edu.cnm.deepdive.sieve.bitset;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;

public class Sieve {

  private static int[] sieve(int limit) {
    BitSet flags = new BitSet(limit + 1);
    flags.set(2, limit + 1);
    for (int prime = 2; prime <= Math.sqrt(limit); prime = flags.nextSetBit(prime + 1)) {
      for (int multiple = prime * prime; multiple <= limit; multiple += prime) {
        flags.clear(multiple);
      }
    }
    return flags
        .stream()
        .toArray();
  }

  public static void main(String... args) {
    System.out.println(Arrays.toString(sieve(1_000_000)));
  }

}
