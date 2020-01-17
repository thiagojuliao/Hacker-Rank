package br.com.thiagojuliao.arrays

import scala.io.StdIn.readLine

object MaximumSwaps2 {
	
	def minimumSwaps(arr: Array[Int]): Int = {
		
		def swapper(iter: Int, acc: Int): Int = {
			if (iter < arr.size) {
				if (arr(iter) - 1 == iter) swapper(iter + 1, acc)
				else {
					val aux = arr(iter)
					val index = arr(iter) - 1
					
					arr(iter) = arr(index)
					arr(index) = aux
					
					swapper(iter, acc + 1)
				}
			}
			else acc
		}
		
		swapper(0, 0)
	}
	
	
	def main(args: Array[String]) {
		val n = readLine.trim.toInt
		val arr = readLine.split(" ").map(_.trim.toInt)
		
		println(minimumSwaps(arr))
	}
}