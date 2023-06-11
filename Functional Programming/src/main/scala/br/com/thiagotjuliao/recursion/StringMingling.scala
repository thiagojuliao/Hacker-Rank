package br.com.thiagotjuliao.recursion

object StringMingling {
  /**
   * Pawel and Shaka recently became friends. They believe their friendship will last forever if they merge their favorite strings.
   *
   * The lengths of their favorite strings are the same, n.
   * Mingling two strings, P = p1p2...  and Q = q1q2..., both of length n, will result in the creation of a new string 2n of length .
   * It will have the following structure:
   *  R = p1q1p2q2...pnqn
   * You are given two strings  (Pawel's favorite) and  (Shaka's favorite), determine the mingled string .
   */
  def main(args: Array[String]): Unit = {
    def mingle(s1: String, s2: String): String = {
      val c1: Seq[String] = s1.toSeq.map(_.toString)
      val c2: Seq[String] = s2.toSeq.map(_.toString)

      c1.zip(c2).foldLeft(""){ case (acc, (s1, s2)) =>
        acc + s1 + s2
      }
    }

    val s1: String = io.StdIn.readLine().trim
    val s2: String = io.StdIn.readLine().trim

    println(mingle(s1, s2))
  }
}
