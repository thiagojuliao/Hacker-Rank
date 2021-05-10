package br.com.thiagotjuliao

import java.io._
import scala.io._

object TimeConversion {

  /*
   * Complete the 'timeConversion' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  def timeConversion(s: String): String = {
    // Write your code here
    val time = s
    val hourPattern = raw"(\d{2}):\d{2}:\d{2}(\w+)".r

    val militaryTime = time match {
      case hourPattern("12", "AM") => time.replace("12", "00").replace("AM", "")
      case hourPattern(h, "AM") => time.replace("AM", "")
      case hourPattern("12", "PM") => time.replace("PM", "")
      case hourPattern(h, "PM") => time.replace(h, (h.toInt + 12).toString).replace("PM", "")
    }

    militaryTime
  }

}

object TimeConversionSolution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val s = StdIn.readLine

    val result = TimeConversion.timeConversion(s)

    printWriter.println(result)

    printWriter.close()
  }
}

