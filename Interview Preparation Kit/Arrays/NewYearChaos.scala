package br.com.thiagojuliao.arrays

import scala.io.StdIn.readLine

object NewYearChaos {
	
	def minimumBribes(q: Array[Int]): Unit = {
		val Q = q.map(i => i - 1)
		
		def helper(i: Int, bribes: Int): Unit = {
			if (i == Q.size) println(bribes)
			else if (Q(i) - i > 2) println("Too chaotic")
			else {
				def getBribes(j: Int, acc: Int): Int = {
					if (j == i) acc
					else if (Q(j) > Q(i)) getBribes(j + 1, acc + 1)
					else getBribes(j + 1, acc)
				}
				helper(i + 1, getBribes(Math.max(0, Q(i) - 2), bribes))
			}
		}
		
		helper(0, 0)
	}	
	
	
	def main(args: Array[String]) = {
		val t = readLine.toInt
		
		for (tIter <- 0 until t) {
			val n = readLine.toInt
			val q = readLine.split(" ").map(_.trim.toInt)
			
			minimumBribes(q)
		}
	}
}