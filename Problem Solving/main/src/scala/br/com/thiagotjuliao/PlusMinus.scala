package br.com.thiagotjuliao

import java.text._
import java.util._
import scala.io._

object PlusMinus {

  /*
   * Complete the 'plusMinus' function below.
   *
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  def plusMinus(arr: Array[Int]) {
    // Write your code here
    val nf = NumberFormat.getInstance(Locale.ENGLISH)
    nf.setMaximumFractionDigits(6)

    val totalPositives = arr.count(_ > 0).toDouble
    val totalNegatives = arr.count(_ < 0).toDouble
    val totalZeros = arr.count(_ == 0).toDouble

    val positivesRatio = totalPositives / arr.length
    val negativesRatio = totalNegatives / arr.length
    val zerosRatio = totalZeros / arr.length

    println(nf.format(positivesRatio))
    println(nf.format(negativesRatio))
    println(nf.format(zerosRatio))
  }

}

private object PlusMinusSolution {
  def main(args: Array[String]) {
    val n = StdIn.readLine.trim.toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    PlusMinus.plusMinus(arr)
  }
}
