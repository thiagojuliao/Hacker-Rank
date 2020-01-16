package br.com.thiagojuliao.warmupchallenges

import scala.io.StdIn.readLine

object RepeatedString {
	
	def main(args: Array[String]) = {
	  val s = readLine.trim()
	  val n = readLine.toLong
	  
	  val as = s.count(_ == 'a')
	  val q = n / s.length()
	  val r = (n % s.length()).toInt
	  
	  if (s.length() == 1 && s == "a") println(n)
	  else println(q * as + s.substring(0, r).count(_ == 'a'))
	}
}