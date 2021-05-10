package br.com.thiagotjuliao

import java.io._
import scala.io._

object BirthdayCakeCandles {

  /*
   * Complete the 'birthdayCakeCandles' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY candles as parameter.
   */

  def birthdayCakeCandles(candles: Array[Int]): Int = {
    // Write your code here
    val maxHeight = candles.max
    candles.count(_ == maxHeight)
  }

}

object BirthdayCakeCandlesSolution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val candlesCount = StdIn.readLine.trim.toInt

    val candles = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = BirthdayCakeCandles.birthdayCakeCandles(candles)

    printWriter.println(result)

    printWriter.close()
  }
}

