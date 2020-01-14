package br.com.thiagojuliao.warmupchallenges

import scala.io.StdIn.readLine

object JumpingOnTheClouds extends App {
  val n = readLine.toInt
  val c = readLine.split(" ").map(_.trim.toInt)
  
  def getMinimumJumps(iter: Int, c: Array[Int], jumps: Int): Int = {
    if (iter == c.length - 3 || iter == c.length - 2) {
      jumps + 1
    }
    else if (c(iter + 2) == 0){
      getMinimumJumps(iter + 2, c, jumps + 1)
    }else {
      getMinimumJumps(iter + 1, c, jumps + 1)
    }
  }
  
  val minimumJumps = getMinimumJumps(0, c, 0)
  println(minimumJumps)
}