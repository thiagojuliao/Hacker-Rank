package br.com.thiagotjuliao.recursion

import scala.annotation.tailrec

object FibonnaciNumbers {
  /**
   * Given the starter code, complete the Fibonacci function to return the Nth term.
   *
   * We start counting from Fibonacci(1) = 0. This might differ from some other notations that treats Fibonacci(0) = 0.
   */
  def main(args: Array[String]): Unit = {
    def fibonnaci(x: Int): Int = {

      @tailrec
      def helper(fib2: Int, fib1: Int, n: Int, acc: Int): Int = {
        if (n == 1) 0
        else if (n == 2) 1
        else if (n > x) acc
        else helper(fib1, fib1 + fib2, n + 1, fib1 + fib2)
      }

      helper(0, 1, 3, 1)
    }

    val N: Int = io.StdIn.readInt()

    println(fibonnaci(N))
  }
}
