package edu.cnm.deepdive.scala.bitset

import scala.annotation.tailrec
import scala.collection.mutable

object Sieve {

  def sieve(limit: Int): mutable.BitSet = {
    val candidates: mutable.BitSet = mutable.BitSet.empty ++ (2 to limit)
    val sqrtLimit = math.sqrt(limit).toInt

    @tailrec
    def prime(value: Int): Unit = {
      if (value <= sqrtLimit) {
        if (candidates contains value) {
          candidates --= (value * value to limit by value)
        }
        prime(value + 1)
      }
    }

    prime(2)
    candidates
  }

  def main(args: Array[String]): Unit = {
    val start = System.currentTimeMillis()
    val upperBound = 1_000_000
    val primes = sieve(upperBound)
    val end = System.currentTimeMillis()
    println(
      s"""Scala Sieve with BitSet and Seq<Int>:
         |${primes.size} primes found between ${primes.firstKey} and ${primes.lastKey} (inclusive) in ${end - start} ms.""".stripMargin
    )
  }

}
