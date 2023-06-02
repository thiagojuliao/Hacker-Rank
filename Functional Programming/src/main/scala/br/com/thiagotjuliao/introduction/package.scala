package br.com.thiagotjuliao

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.BufferedSource

package object introduction {

  def getIntsInputList: List[Int] = {
    var stopFlag: Boolean = false

    val ls: mutable.ListBuffer[Int] = ListBuffer.empty
    val source: BufferedSource = io.Source.stdin

    while (!stopFlag) {
      val ln: String = source.getLines().next()

      if (ln != null && ln.nonEmpty) ls.addOne(ln.toInt)
      else stopFlag = true
    }

    source.close()

    ls.toList
  }
}
