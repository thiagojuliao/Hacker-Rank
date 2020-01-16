package br.com.thiagojuliao.arrays

import scala.io.StdIn.readLine
import java.util.Arrays

object ArraysLeftRotation {
  
  def rotLeft(a: Array[Int], d: Int): Array[Int] = {
    val rotated = Array.ofDim[Int](a.length)
    
    for (i <- 0 until a.length) {
      if (i - d < 0) rotated(i - d + a.length) = a(i)
      else rotated(i - d) = a(i)
    }
    
    rotated
  }
  
  
  def main(args: Array[String]) = {
	  val nd = readLine.split(" ")
	  val arr = readLine.split(" ").map(_.trim.toInt) 
	  
	  val n = nd(0).trim.toInt
	  val d = nd(1).trim.toInt
	  
	  println(Arrays.toString(rotLeft(arr, d)))
  }
}