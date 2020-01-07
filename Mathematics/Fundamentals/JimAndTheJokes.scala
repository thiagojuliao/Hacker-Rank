package com.hackerrank.mathematics.fundamentals

import scala.io.StdIn.readLine

object JimAndTheJokes {
  
  private var count: Long = 0
  
  private def toBase10(date: Array[Int]): Int = {
    if (date(0) == 10) date(1)
    else (date(1) / 10) * date(0) + (date(1) % 10)
  }
  
  private def countJokes(inputDates: Array[Int], dates: Array[Int]): Unit = {
    for (inputDate <- inputDates) {
      val dateCount: Long = dates.count(_ == inputDate)
      val groupsOf2: Long = (dateCount * (dateCount - 1)) / 2
      
      count += groupsOf2
    }
  }
  
  def solve(dates: Array[Array[Int]]): Long = {
    val validDates = dates
      .filter(date => date(0) > date(1)/10 && date(0) > date(1) % 10)
      .filter(date => (date(0) == 11 && date(1) != 10)
          || (date(0) == 12 && (date(1) != 10 || date(1) != 11))
          || (date(0) != 11 || date(0) != 12))
    
    val base10Dates = validDates.map(date => toBase10(date))
    val datesToCount = base10Dates.distinct
    
    if (!datesToCount.isEmpty) countJokes(datesToCount, base10Dates)
    count
  }

  def main(args: Array[String]) = {

    val n = readLine.trim.toInt
    val dates = Array.ofDim[Int](n, 2)

    for (datesRowIter <- 0 until n) {
      dates(datesRowIter) = readLine.split(" ").map(_.trim.toInt)
    }
    
    val result = solve(dates)
    println(result)
  }
}