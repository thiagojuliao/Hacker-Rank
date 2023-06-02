package br.com.thiagotjuliao.introduction

import scala.annotation.tailrec

object FilterArray {
  /**
   * Filter a given array of integers and output only those values that are less than a specified value X.
   * The output integers should be in the same sequence as they were in the input.
   * You need to write a function with the recommended method signature for the languages mentioned below.
   * For the rest of the languages, you have to write a complete code.
   */
  def main(args: Array[String]): Unit = {
    def f(delim: Int, arr: List[Int]): List[Int] = {

      @tailrec
      def helper(arr: List[Int], acc: List[Int]): List[Int] = {
        if (arr.isEmpty) acc
        else if (arr.head < delim) helper(arr.tail, acc :+ arr.head)
        else helper(arr.tail, acc)
      }

      helper(arr, List.empty[Int])
    }

    val delim: Int = io.StdIn.readInt()
    val ints: List[Int] = getIntsInputList

    f(delim, ints).foreach(println)
  }
}
