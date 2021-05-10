package br.com.thiagotjuliao

import java.io._
import scala.io._
import scala.math._

object DiagonalDifference {

  /*
   * Complete the 'diagonalDifference' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY arr as parameter.
   */

  def diagonalDifference(arr: Array[Array[Int]]): Int = {
    // Write your code here
    val leftDiag = for {
      i <- arr.indices
      j <- arr.indices if i == j
    } yield {
      arr(i)(j)
    }

    val rightDiag = for {
      i <- arr.indices
      j <- arr.indices if i == j
    } yield {
      arr(i).reverse(j)
    }

    abs(leftDiag.sum - rightDiag.sum)
  }

}

private object DiagonalDifferenceSolution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = StdIn.readLine.trim.toInt

    val arr = Array.ofDim[Int](n, n)

    for (i <- 0 until n) {
      arr(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    }

    val result = DiagonalDifference.diagonalDifference(arr)

    printWriter.println(result)

    printWriter.close()
  }
}
