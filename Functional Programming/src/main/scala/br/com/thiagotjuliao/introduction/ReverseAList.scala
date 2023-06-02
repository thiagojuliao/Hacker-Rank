package br.com.thiagotjuliao.introduction

import scala.annotation.tailrec

object ReverseAList {
  /**
   * You are given a list of N elements.
   * Reverse the list without using the reverse function.
   * The input and output portions will be handled automatically.
   * You need to write a function with the recommended method signature.
   */
  def main(args: Array[String]): Unit = {
    def f(arr: List[Int]): List[Int] = {

      @tailrec
      def helper(ls: List[Int], acc: List[Int]): List[Int] = {
        if (ls.isEmpty) acc
        else helper(ls.tail, ls.head +: acc)
      }

      helper(arr, List.empty)
    }

    val ints: List[Int] = getIntsInputList

    f(ints).foreach(println)
  }
}
