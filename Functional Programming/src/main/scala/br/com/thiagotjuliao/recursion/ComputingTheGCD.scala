package br.com.thiagotjuliao.recursion

import scala.annotation.tailrec

object ComputingTheGCD {
  /**
   * Given two integers, x and y, a recursive technique to find their GCD is the Euclidean Algorithm.
   *
   * The algorithm states that, for computing the GCD of two positive integers x and y, if x and y are equal, GCD(x, y) = x.
   * Otherwise GCD(x, y) = GCD(x - y, y) if x > y.
   * There are a few optimizations that can be made to the above logic to arrive at a more efficient implementation.
   */
  def main(args: Array[String]): Unit = {

    @tailrec
    def gcd(x: Int, y: Int): Int = {
      if (x == 1 || y == 1) 1
      else if (x == y) x
      else {
        if (x > y) gcd(x - y, y)
        else gcd(x, y - x)
      }
    }

    val input: Array[Int] = io.StdIn.readLine().trim.split(" ").map(_.toInt)

    println(gcd(input(0), input(1)))
  }
}
