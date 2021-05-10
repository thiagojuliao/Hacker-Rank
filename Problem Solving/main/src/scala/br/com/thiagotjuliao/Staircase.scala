package br.com.thiagotjuliao

import scala.io._

object Staircase {

  /*
   * Complete the 'staircase' function below.
   *
   * The function accepts INTEGER n as parameter.
   */

  def staircase(n: Int) {
    // Write your code here
    val staircase = for {
      i <- 1 to n
    } yield {
      " " * (n - i) + "#" * i
    }

    staircase.foreach(println)
  }

}

object StaircaseSolution {
  def main(args: Array[String]) {
    val n = StdIn.readLine.trim.toInt

    Staircase.staircase(n)
  }
}

