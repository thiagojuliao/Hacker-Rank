package br.com.thiagojuliao.arrays

import scala.io.StdIn.readLine

object Array2D_DS {
 
  def hourglassSum(arr: Array[Array[Int]]): Int = {
    var maxSum = Int.MinValue
    
    for (i <- 0 until 4) {
      for (j <- 0 until 4) {
        var top = arr(i).slice(j, j + 3).sum
        var mid = arr(i + 1)(j + 1)
        var bot = arr(i + 2).slice(j, j + 3).sum
        
        maxSum = Math.max(maxSum, top + mid + bot)
      }
    }
    
    maxSum
  }
  
  
  def main(args: Array[String]) = {
	  val arr: Array[Array[Int]] = Array.ofDim[Int](6, 6)
  
	  for (i <- 0 until 6) {
	    arr(i) = readLine.split(" ").map(_.trim.toInt)
	  }
	  
	  println(hourglassSum(arr))
  }
}