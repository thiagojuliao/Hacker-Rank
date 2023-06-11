package br.com.thiagotjuliao.recursion

object FilterElements {
  /**
   * Given a list of N integers A = [a1, a2, ..., aN], you have to find those integers which are repeated at least K times.
   * In case no such element exists you have to print -1.
   *
   * If there are multiple elements in A which are repeated at least K times,
   * then print these elements ordered by their first occurrence in the list.
   *
   * Let's say A = [4, 5, 2, 5, 4, 3, 1, 3, 4] and K = 2. Then the output is: 453
   */
  def main(args: Array[String]): Unit = {

    val T: Int = io.StdIn.readInt()

    (1 to T).map { _ =>
      val params: Array[String] = io.StdIn.readLine().trim.split(" ")
      val input: List[Int] = io.StdIn.readLine().trim.split(" ").map(_.toInt).toList

      val K: Int = params(1).toInt

      val result: List[Int] = input.zipWithIndex.groupBy(_._1)
        .filter(_._2.length >= K)
        .toList
        .sortBy(_._2.head._2)
        .map(_._1)

      if (result.isEmpty) "-1"
      else result.mkString(" ")
    }
    .foreach(println)
  }
}
