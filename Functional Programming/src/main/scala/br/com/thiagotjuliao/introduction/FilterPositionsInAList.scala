package br.com.thiagotjuliao.introduction

import scala.annotation.tailrec

object FilterPositionsInAList {
  /**
   * For a given list with N integers, return a new list removing the elements at odd positions.
   * The input and output portions will be handled automatically.
   * You need to write a function with the recommended method signature.
   */
  def main(args: Array[String]): Unit = {
    def f(arr: List[Int]): List[Int] = {

      @tailrec
      def extractor(ls: List[Int], acc: Vector[Int]): List[Int] = {
        if (ls.isEmpty) acc.toList
        else ls match {
            case _ :: th :: tt => extractor(tt, acc :+ th)
            case _ :: Nil => extractor(Nil, acc)
          }
      }

      extractor(arr, Vector.empty)
    }

    val ints: List[Int] = getIntsInputList

    f(ints).foreach(println)
  }
}
