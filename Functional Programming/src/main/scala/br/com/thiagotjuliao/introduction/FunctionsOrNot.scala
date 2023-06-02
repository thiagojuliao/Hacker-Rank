package br.com.thiagotjuliao.introduction

import scala.collection.mutable.ListBuffer

object FunctionsOrNot {
  /**
   * In this problem, we touch upon a basic concept that is fundamental to Functional Programming: identifying a relation which represents a valid function.
   */
  def main(args: Array[String]): Unit = {
    def check: Boolean = {
      val N: Int = io.StdIn.readLine().trim.toInt
      val tuples: ListBuffer[(Int, Int)] = ListBuffer.empty

      (1 to N).foreach { _ =>
        val input: Array[Int] = io.StdIn.readLine().trim.split(" ").map(_.toInt)

        tuples.addOne((input(0), input(1)))
      }

      val fmap: Map[Int, Int] = Map.from(tuples)

      tuples.foldLeft(true){ case (acc, (x, y)) =>
        acc && (y == fmap(x))
      }
    }

    val T: Int = io.StdIn.readLine().trim.toInt

    val results: Seq[String] = (1 to T).map { _ =>
      if (check) "YES" else "NO"
    }

    results.foreach(println)
  }
}
