package br.com.thiagotjuliao.introduction

import scala.annotation.tailrec

object ListLength {
  /**
   * Count the number of elements in an array without using count, size or length operators (or their equivalents).
   * The input and output portions will be handled automatically by the grader.
   * You only need to write a function with the recommended method signature.
   */
  def main(args: Array[String]): Unit = {
    def f(arr: List[Int]): Int = {

      @tailrec
      def counter(ls: List[Int], acc: Int): Int = {
        if (ls.isEmpty) acc
        else counter(ls.tail, acc + 1)
      }

      counter(arr, 0)
    }

    val ints: List[Int] = getIntsInputList

    println(f(ints))
  }
}
