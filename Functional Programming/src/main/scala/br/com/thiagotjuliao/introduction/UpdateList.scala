package br.com.thiagotjuliao.introduction

object UpdateList {
  /**
   * Update the values of a list with their absolute values.
   * The input and output portions will be handled automatically during grading.
   * You only need to write a function with the recommended method signature.
   */
  def main(args: Array[String]): Unit = {
    def f(arr: List[Int]): List[Int] = arr.map(Math.abs)

    val ints: List[Int] = getIntsInputList

    f(ints).foreach(println)
  }
}
