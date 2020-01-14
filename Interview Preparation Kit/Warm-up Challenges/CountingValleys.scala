package br.com.thiagojuliao.warmupchallenges

import scala.io.StdIn.readLine

object CountingValleys extends App {
  val n = readLine.toInt
  val steps = readLine.toCharArray()
  
  def countValley(iter: Int, steps: Array[Char], level: Int, 
      valleyStart: Boolean, countingValleys: Int): Int = {
    if (iter > steps.length - 1) {
      countingValleys
    }
    else if (level == 0 && steps(iter) == 'D' && valleyStart == false) {
      countValley(iter + 1, steps, level - 1, true, countingValleys)
    }
    else if (level + 1 == 0 && steps(iter) == 'U' && valleyStart == true) {
      countValley(iter + 1, steps, 0, false, countingValleys + 1)
    }else if (steps(iter) == 'D') {
      countValley(iter + 1, steps, level - 1, valleyStart, countingValleys)
    }else {
      countValley(iter + 1, steps, level + 1, valleyStart, countingValleys)
    }
  }
  
  val countingValleys = countValley(0, steps, 0, false, 0)
  println(countingValleys)
}