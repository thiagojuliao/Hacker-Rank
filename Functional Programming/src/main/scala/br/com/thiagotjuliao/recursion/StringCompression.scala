package br.com.thiagotjuliao.recursion

import scala.util.matching.Regex

object StringCompression {
  /**
   * Joseph and Jane are making a contest for apes. During the process, they have to communicate frequently with each other.
   * Since they are not completely human, they cannot speak properly. They have to transfer messages using postcards of small sizes.
   * To save space on the small postcards, they devise a string compression algorithm:
   *
   * If a character, ch, occurs n(> 1) times in a row, then it will be represented by {ch}{n}, where {n} is the value of n.
   * For example, if the substring is a sequence of 4'a' ("aaaa"), it will be represented as "a4".
   *
   * If a character, ch, occurs exactly one time in a row, then it will be simply represented as {ch}.
   * For example, if the substring is "a", then it will be represented as "a".
   *
   * Help Joseph to compress a message, msg.
   */
  def main(args: Array[String]): Unit = {
    val s: String = io.StdIn.readLine().trim

    val chars: Seq[String] = Seq(
      "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
      "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "x", "w", "y", "z"
    )

    val groupPattern: Regex = chars.map(c => s"($c{2,})").reduce(_ + "|" + _).r

    val compressed: String = groupPattern.findAllIn(s).toVector
      .sortBy(_.length * -1)
      .foldLeft(s){ (acc, group) =>
        acc.replace(group, s"${group.head}${group.length}")
      }

    println(compressed)
  }
}
