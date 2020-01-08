package br.com.thiagojuliao

import scala.io.StdIn.readLine

object SockMerchant {
  
  private var numberOfPairs: Int = 0
  
  def sockMerchant(n: Int, ar: Array[Int]): Int = {
    val socks = ar.distinct
    
    for (sock <- socks) {
      numberOfPairs += ar.count(_ == sock) / 2
    }
    
    numberOfPairs
  }
  
  def main(args: Array[String]) = {
    val n = readLine.trim.toInt
    val ar = readLine.split(" ").map(_.trim.toInt)
    
    println(sockMerchant(n, ar))
  }
}