package br.com.thiagotjuliao.introduction

import scala.annotation.tailrec

object EvaluatingExp {
  /**
   * The series expansion of exp(X) is given by:
   * exp(X) = 1 + X + X²/2! + X³/3! + ...
   * Evaluate expr(X) for given values of X by using the above expansion for the first 10 terms.
   */
  def main(args: Array[String]): Unit = {
    def fact(n: Int): Int = {

      @tailrec
      def compute(n: Int, acc: Int): Int = {
        if (n <= 1) acc
        else compute(n - 1, acc * n)
      }

      compute(n, 1)
    }

    def exp10(x: Double): Double = {

      @tailrec
      def expansion(term: Int, acc: Double): Double = {
        if (term > 10) acc
        else {
          val powValue: Double = Math.pow(x, term - 1)
          val factValue: Int = fact(term - 1)
          val result: Double = powValue / factValue

          expansion(term + 1, acc + result)
        }
      }

      BigDecimal(expansion(1, 0)).setScale(4, BigDecimal.RoundingMode.HALF_UP).toDouble
    }

    val doubles: List[Double] = List(20.0000, 5.0000, 0.5000, -0.5000)

    doubles.map(exp10).foreach(println)
  }
}
