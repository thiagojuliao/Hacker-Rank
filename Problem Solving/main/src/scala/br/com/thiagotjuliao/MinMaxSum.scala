package br.com.thiagotjuliao

import scala.io._

object MinMaxSum {

  /*
   * Complete the 'miniMaxSum' function below.
   *
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  def miniMaxSum(arr: Array[Int]) {
    // Write your code here
    val ordered: Array[Long] = arr.sorted.map(_.toLong)

    print(ordered.slice(0, 4).sum + " " + ordered.slice(1, 5).sum)
  }

}

object MinMaxSumSolution {
  def main(args: Array[String]) {

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    MinMaxSum.miniMaxSum(arr)
  }
}

