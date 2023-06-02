package br.com.thiagotjuliao.introduction

object HelloWorldNTimes {
  /**
   * Print "Hello World" N amount of times.
   * The input portion will be handled automatically. You need to write a function with the recommended method signature.
   */
  def main(args: Array[String]): Unit = {
    def f(n: Int): Unit =
      (1 to n).map(_ => "Hello World").foreach(println)

    val n: Int = io.StdIn.readInt()

    f(n)
  }
}
