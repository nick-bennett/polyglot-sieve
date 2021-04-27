package edu.cnm.deepdive

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
    println(sieve(1_000_000))
  }

}
