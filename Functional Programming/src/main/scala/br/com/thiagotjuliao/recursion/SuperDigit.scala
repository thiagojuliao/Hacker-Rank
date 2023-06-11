package br.com.thiagotjuliao.recursion

import scala.annotation.tailrec

object SuperDigit {
  /**
   * We define super digit of an integer x using the following rules:
   *
   * If x has only  digit, then its super digit is x.
   * Otherwise, the super digit of x is equal to the super digit of the digit-sum of x.
   * Here, digit-sum of a number is defined as the sum of its digits.
   *
   * You are given two numbers n and k. You have to calculate the super digit of P where P is created when number n is concatenated k times.
   */
  def main(args: Array[String]): Unit = {

    val input: Array[String] = io.StdIn.readLine().trim.split(" ")
    val n: String = input(0)
    val k: Int = input(1).toInt

    val N: String = n.toVector.map(_.toString.toInt).sum.toString * k

    @tailrec
    def superDigit(s: String): Int = {
      if (s.length== 1) s.toInt
      else superDigit(s.toVector.map(_.toString.toInt).sum.toString)
    }

    println(superDigit(N))
  }
}
