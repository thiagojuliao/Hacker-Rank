package br.com.thiagotjuliao.recursion

import scala.annotation.tailrec

object PrefixCompression {
  /**
   * You are in charge of data transfer between two Data Centers.
   * Each set of data is represented by a pair of strings.
   * Over a period of time you have observed a trend: most of the times both strings share some prefix.
   * You want to utilize this observation to design a data compression algorithm which will be used to reduce amount of data to be transferred.
   *
   * You are given two strings, x and y, representing the data, you need to find the longest common prefix (p) of the two strings.
   * Then you will send substring p, x' and y', where x' and y' are the substring left after stripping p from them.
   *
   * For example, if x = "abcdefpr" and y = "abcpqr", then p = "abc",x' = "defpr",y' = "pqr".
   */
  def main(args: Array[String]): Unit = {

    def prefixCompression(s1: String, s2: String): Unit = {
      def updateAccumulator(buffer: String, acc: String): String =
        if (buffer.length > acc.length) buffer
        else acc

      def printResult(s: String): Unit =
        println(s"${s.length} $s")

      @tailrec
      def getLCP(s: String, S: String, buffer: String, acc: String): String = {
        if (s.isEmpty && buffer.isEmpty) acc
        else if (s.isEmpty && buffer.nonEmpty) updateAccumulator(buffer, acc)
        else if (s.head == S.head)
          getLCP(s.tail, S.tail, buffer + s.head, acc)
        else if (buffer.nonEmpty)
          getLCP(s.tail, S.tail, "", updateAccumulator(buffer, acc))
        else getLCP(s.tail, S.tail, "", acc)
      }

      val lcp: String = {
        if (s1 == s2) s1
        else if (s2 contains s1) s1
        else if (s1 contains s2) s2
        else if (s1.length > s2.length) getLCP(s2, s1, "", "")
        else getLCP(s1, s2, "", "")
      }

      val s1_ : String = s1.replace(lcp, "")
      val s2_ : String = s2.replace(lcp, "")

      Seq(lcp, s1_, s2_).foreach(printResult)
    }

    val s1: String = io.StdIn.readLine().trim
    val s2: String = io.StdIn.readLine().trim

    prefixCompression(s1, s2)
  }
}

object AlternativeSolution {
  /**
   * Found at discussion posted by Todd_Leo
   * An elegant way using built-in collection functions like zip and takeWhile
   */
  def main(args: Array[String]): Unit = {

    val s1: String = io.StdIn.readLine().trim
    val s2: String = io.StdIn.readLine().trim

    val common: String = s1.zip(s2).takeWhile { case (c1, c2) => c1 == c2 }
      .map(_._1).mkString("")

    val commonSize: Int = common.length
    val s1_ : String = s1.drop(commonSize)
    val s2_ : String = s2.drop(commonSize)

    println(s"$commonSize ${s1.take(commonSize)}")
    println(s"${s1_.length} $s1_")
    println(s"${s2_.length} $s2_")
  }
}
