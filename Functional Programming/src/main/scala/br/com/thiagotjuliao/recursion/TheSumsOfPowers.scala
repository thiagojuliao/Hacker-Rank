package br.com.thiagotjuliao.recursion

object TheSumsOfPowers {
  /**
   * Find the number of ways that a given integer, X, can be expressed as the sum of the Nth power of unique, natural numbers.
   */
  def main(args: Array[String]): Unit = {

    def numberOfWays(X: Int, N: Int): Int = {
      val upperBound: Int = Math.pow(X, 1.0 / N).toInt
      val numbers: List[Int] = (1 to upperBound).map(Math.pow(_, N).toInt).toList
      val validNumbers: List[Int] = numbers.filter(_ <= X)

      def counter(z: Int, numbers: List[Int]): Int = {
        numbers match {
          case Nil => 0
          case h :: t =>
            if (h == z) 1
            else if (h > z) counter(z, t)
            else counter(z - h, t) + counter(z, t)
        }
      }

      counter(X, validNumbers)
    }

    val X: Int = io.StdIn.readInt()
    val N: Int = io.StdIn.readInt()

    println(numberOfWays(X, N))
  }
}
