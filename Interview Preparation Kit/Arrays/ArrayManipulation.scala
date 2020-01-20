package br.com.thiagojuliao.arrays

import scala.io.StdIn.readLine

object ArrayManipulation {
	
	def arrayManipulation(n: Int, queries: Array[Array[Int]]): Long = {
		val arr = Array.ofDim[Long](n + 1)
		var max: Long = 0
		var x: Long = 0
		
		for (query <- queries) {
			val p = query(0)
			val q = query(1)
			val sum = query(2)
			
			arr(p) += sum
			
			if (q + 1 <= n) arr(q + 1) -= sum
		}
		
		for (i <- 1 to n) {
			x += arr(i)
			max = Math.max(max, x)
		}
		
		max
    }
	
	def main(args: Array[String]) = {
		val nm = readLine.split(" ").map(_.trim.toInt)
		val n = nm(0)
		val m = nm(1)
		
		val queries = Array.ofDim[Int](m, 3)
		
		for (i <- 0 until m) {
            queries(i) = readLine.split(" ").map(_.trim.toInt)
        }

        val result = arrayManipulation(n, queries)
        
        println(result)
	}
}