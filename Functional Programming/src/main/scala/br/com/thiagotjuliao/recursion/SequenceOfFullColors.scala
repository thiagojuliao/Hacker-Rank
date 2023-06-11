package br.com.thiagotjuliao.recursion

import scala.annotation.tailrec

object SequenceOfFullColors {
  /**
   * You are given a sequence of N balls in 4 colors: red, green, yellow and blue.
   * The sequence is full of colors if and only if all of the following conditions are true:
   *
   * • There are as many red balls as green balls.
   * • There are as many yellow balls as blue balls.
   * • Difference between the number of red balls and green balls in every prefix of the sequence is at most 1.
   * • Difference between the number of yellow balls and blue balls in every prefix of the sequence is at most 1.
   * Your task is to write a program, which for a given sequence prints True if it is full of colors, otherwise it prints False.
   */
  def main(args: Array[String]): Unit = {

    def fullOfColors(s: String): String = {

      @tailrec
      def isColorful(ls: List[String], R: Int, G: Int, B: Int, Y: Int): Boolean =
        ls match {
          case Nil => R == G && B == Y
          case h :: t if Math.abs(R - G) <= 1 && Math.abs(Y - B) <= 1 =>
            h match {
              case "R" => isColorful(t, R + 1, G, B, Y)
              case "G" => isColorful(t, R, G + 1, B, Y)
              case "B" => isColorful(t, R, G, B + 1, Y)
              case "Y" => isColorful(t, R, G, B, Y + 1)
            }
          case _ => false
        }

      if (isColorful(s.toList.map(_.toString), 0, 0, 0, 0)) "True" else "False"
    }

    val N: Int = io.StdIn.readInt()

    (1 to N).map(_ => io.StdIn.readLine().trim).map(fullOfColors).foreach(println)
  }
}
