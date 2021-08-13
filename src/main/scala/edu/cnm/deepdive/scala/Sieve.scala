package edu.cnm.deepdive.scala

import scala.annotation.tailrec
import scala.collection.mutable

object Sieve {

  def sieve(limit: Int): mutable.Seq[Int] = {
    val primes: mutable.Set[Int] = mutable.Set.empty ++ (2 to limit)
    val sqrtLimit = math.sqrt(limit).toInt

    @tailrec
    def prime(value: Int): Unit = {
      if (value <= sqrtLimit) {
        if (primes contains value) {
          primes --= (value * value to limit by value)
        }
        prime(value + 1)
      }
    }

    prime(2)
    (mutable.Seq.empty ++ primes).sorted
  }

  def main(args: Array[String]): Unit = {
    val start = System.currentTimeMillis()
    val upperBound = 1_000_000
    val primes = sieve(upperBound)
    val end = System.currentTimeMillis()
    println(
      s"""Kotlin Sieve with BooleanArray and List<Int>:
         |${primes.size} primes found between 2 and $upperBound in ${end - start} ms.""".stripMargin
    )
  }

}
