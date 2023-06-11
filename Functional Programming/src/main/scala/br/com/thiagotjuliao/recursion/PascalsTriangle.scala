package br.com.thiagotjuliao.recursion

import scala.annotation.tailrec

object PascalsTriangle {
  /**
   * For a given integer K, print the first K rows of Pascal's Triangle.
   * Print each row with each value separated by a single space.
   * The value at the Nth row and Rth column of the triangle is equal to n!/(r! * (n - r)!) where indexing starts from 0.
   * These values are the binomial coefficients.
   */
  def main(args: Array[String]): Unit = {
    def fact(n: Int): Int = {

      @tailrec
      def helper(n: Int, acc: Int): Int = {
        if (n <= 1) acc
        else helper(n - 1, acc * n)
      }

      helper(n, 1)
    }

    def binc(n: Int, r: Int): Int =
      fact(n) / (fact(r) * fact(n - r))

    def printPascalTriangle(size: Int): Unit = {
      (0 until size).foreach { row =>
        (0 to row).foreach(column => print(binc(row, column) + " "))

        println()
      }
    }

    val K: Int = io.StdIn.readInt()

    printPascalTriangle(K)
  }
}
