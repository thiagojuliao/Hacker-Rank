package br.com.thiagotjuliao.introduction

object ArrayOfNElements {
  /**
   * Create an array of N integers, where the value of N is passed as an argument to the pre-filled function in your editor.
   * This challenge uses a custom checker, so you can create any array of  integers.
   * For example, if n = 4, you could return [1, 1, 1, 1], [1, 2, 3, 4], or any other array of equal length.
   */
  def main(args: Array[String]): Unit = {
    def f(num: Int): List[Int] = {
      val arr = Array.ofDim[Int](num)

      print(arr.mkString("[", ", ", "]") + "\n")
      arr.toList
    }

    val readInt = io.StdIn.readInt

    println(f(readInt))
  }
}
