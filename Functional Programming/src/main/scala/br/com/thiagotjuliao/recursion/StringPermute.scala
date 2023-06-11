package br.com.thiagotjuliao.recursion

object StringPermute {
  /**
   * Kazama gave Shaun a string of even length, and asked him to swap the characters at the even positions with the next character.
   * Indexing starts at 0.
   * Formally, given a string str of length L where L is even, Shaun has to swap the characters at position i and i + 1,
   * where i e {0,2,...,L-2}.
   */
  def main(args: Array[String]): Unit = {
    val T: Int = io.StdIn.readLine().trim.toInt

    val results: Seq[String] = (1 to T).map { _ =>
      val s: String = io.StdIn.readLine().trim

      s.grouped(2).map(_.reverse).reduce(_ + _)
    }

    results.foreach(println)
  }
}
