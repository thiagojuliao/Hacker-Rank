package br.com.thiagotjuliao.introduction

object ListReplication {
  /**
   * Given a list, repeat each element in the list n amount of times.
   * The input and output portions will be handled automatically by the grader.
   * You need to write a function with the recommended method signature.
   */
  def main(args: Array[String]): Unit = {
    def f(num: Int, arr: List[Int]): List[Int] =
      arr.flatMap(e => Array.ofDim[Int](num).map(_ => e))

    val times: Int = io.StdIn.readInt
    val input: List[Int] = getIntsInputList

    f(times, input).foreach(println)
  }
}
