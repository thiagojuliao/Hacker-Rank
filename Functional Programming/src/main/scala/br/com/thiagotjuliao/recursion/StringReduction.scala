package br.com.thiagotjuliao.recursion

object StringReduction {
  /**
   * Given a string, str = s1,s2,...sn, consisting of n lowercase English characters (a - z),
   * remove all of the characters that occurred previously in the string.
   * Formally, remove all characters, si, for:
   * Ej, sj = si and j < i
   */
  def main(args: Array[String]): Unit = {

    val s: String = io.StdIn.readLine().trim

    val result: String = s.foldLeft("") { case (acc, char) =>
      if (!(acc contains char)) acc + char
      else acc
    }

    println(result)
  }
}
