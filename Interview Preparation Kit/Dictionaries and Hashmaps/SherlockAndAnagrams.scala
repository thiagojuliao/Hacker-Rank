package br.com.thiagojuliao.dictionaries_and_hashmaps

import scala.io.StdIn.readLine
import scala.collection.mutable.ListBuffer

object SherlockAndAnagrams {

	def sherlockAndAnagrams(s: String): Int = {

		def buildList(start: Int, s: String, lb: ListBuffer[String]): Unit = {
			val substr = s.substring(start)
			
			lb += s(start).toString()
			substr.toList.map(_.toString).reduce((s1, s2) => {
				val s_ = s1 + s2
				lb += s_
				s_
			})
		}
		
		def getPairs(combs: ListBuffer[String], pairs: ListBuffer[(String, String)]): Unit = {
			
			(0 until combs.size - 1).foreach(i => {
				val string = combs(i)
				val slice = combs.slice(i + 1, combs.size)
				
				slice.foreach(s => {
					if (string.intersect(s) == string) pairs += (string -> s)
				})
			})
		}
		
		val lb: ListBuffer[String] = ListBuffer()
		val pairs: ListBuffer[(String, String)] = ListBuffer()
		
		(0 until s.size).foreach(i => buildList(i, s, lb))
		lb.groupBy(_.size).values.foreach(lb => getPairs(lb, pairs))
		pairs.size
	}

	def main(args: Array[String]) = {

		val q = readLine.toInt

		for (qIter <- 0 until q) {

			val s = readLine
			val result = sherlockAndAnagrams(s)

			println(result)
		}
	}
}