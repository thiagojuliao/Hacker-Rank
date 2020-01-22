package br.com.thiagojuliao.dictionaries_and_hashmaps

import scala.io.StdIn.readLine

object TwoStrings {
	
	def twoStrings(s1: String, s2: String): String = {
		
		if (!s1.intersect(s2).isEmpty) "YES"
		else "NO"
	}
		
	
	def main(args: Array[String]) = {
		
		val n = readLine.toInt
		
		for (i <- 0 until n) {
			
			val s1 = readLine
			val s2 = readLine
			
			println(twoStrings(s1, s2))
			
		}
	}
}