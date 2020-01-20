package br.com.thiagojuliao.dictionaries_and_hashmaps

import scala.io.StdIn.readLine
import scala.collection.mutable.HashMap

object RansomNote {
 	
	def checkMagazine(magazine: Array[String], note: Array[String]): Unit = {
		
		val magazineMap = new HashMap[String, Int]
		val noteMap = new HashMap[String, Int]
		
		for (s <- note) {
			if (noteMap.contains(s)) noteMap += (s -> (noteMap(s) + 1))
			else noteMap += (s -> 1)
		}
		
		for (s <- magazine) {
			if (magazineMap.contains(s)) magazineMap += (s -> Math.min(noteMap(s), (magazineMap(s) + 1)))
			else if (note.contains(s)) magazineMap += (s -> 1)
		}
		
		if (noteMap.equals(magazineMap)) println("Yes")
		else println("No")
	}
	
	def main(args: Array[String]) = {
		
		val nm = readLine.split(" ").map(_.trim.toInt)
		val n = nm(0)
		val m = nm(1)
		
		val magazine = readLine.split(" ")
		val note = readLine.split(" ")
		
		checkMagazine(magazine, note)
	}
}