package br.com.thiagotjuliao.recursion

import scala.annotation.tailrec

object SierpinskiTriangles {
  /**
   * The Sierpinski Triangle is a pretty fractal which consistes of layers of self-similar triangles, nested inside each other.
   * This challenge involves the construction of such triangles, in the form of ASCII Art.
   * The restriction is, that you need to accomplish this with functional programming, and you cannot declare even local variables!
   *
   * We have to deal with real world constraints, so we cannot keep repeating the pattern infinitely.
   * So, we will provide you a number of iterations, and you need to generate the ASCII version of the Sierpinski Triangle for those many iterations (or, levels of recursion).
   */
  object Config {
    final val MAX_HEIGHT: Int = 32
    final val MAX_WIDTH: Int = 63
  }

  case class Point(x: Int, y: Int) {
    def mid(that: Point): Point =
      Point((this.x + that.x) / 2, (this.y + that.y) / 2)

    def +(t: (Int, Int)): Point =
      Point(this.x + t._1, this.y + t._2)
  }

  case class Triangle(p0: Point, p1: Point, p2: Point) {

    def surface: Seq[Point] =
      (1 to p1.x - p0.x).foldLeft(Seq(p0)) { case (surface, x) =>
        val points: Seq[Point] =
          (p0.y - x to p0.y + x).map(Point(p0.x + x, _))

        surface ++ points
      }

    def printLines(): Unit =
      this.surface.groupBy(_.x).toSeq.sortBy(_._1).map(_._2).foreach { line =>
        val ln: Int = line.head.x

        println(f"$ln%02d: ${line.mkString(" ")}")
      }
  }

  object Matrix {
    type Matrix = Array[Array[Int]]

    def printMatrix(matrix: Matrix): Unit =
      matrix.foreach { row =>
        val rowS: String = row.mkString.replace("0", "_")

        println(rowS)
      }

    def updateMatrix(triangles: Seq[Triangle], matrix: Matrix): Matrix = {
      val surface: Seq[Point] = triangles.flatMap(_.surface)

      matrix.zipWithIndex.map { case (line, lidx) =>
        line.indices.map { cidx =>
          val point: Point = Point(lidx, cidx)

          if (surface contains point) 1
          else 0
        }.toArray
      }
    }
  }

  object Solution {
    import Config._
    import Matrix._

    @tailrec
    private def solve(iter: Int, maxIter: Int, acc: Seq[Triangle]): Seq[Triangle] = {
       if (iter > maxIter) acc
       else {
         val acc_ : Seq[Triangle] = acc.flatMap { case Triangle(p0, p1, p2) =>
           val p0p1: Point = p0.mid(p1)
           val p0p2: Point = p0.mid(p2)
           val p1p2: Point = p1.mid(p2)

           val tri00: Triangle = Triangle(p0, p0p1 + (0, 1), p0p2)
           val tri01: Triangle = Triangle(p0p1 + (1, 0), p1, p1p2 + (0, -1))
           val tri02: Triangle = Triangle(p0p2 + (1, 1), p1p2 + (0, 1), p2)

           Seq(tri00, tri01, tri02)
         }

          solve(iter + 1, maxIter, acc_)
       }
    }

    def apply(maxIter: Int): Unit = {
      val matrix: Matrix = Array.ofDim[Int](MAX_HEIGHT, MAX_WIDTH)
        .zipWithIndex
        .map { case (line, idx) =>
          val totalOnes: Int = 2 * idx + 1
          val start: Int = (MAX_WIDTH - totalOnes) / 2 + 1
          val end: Int = start + totalOnes - 1

          line.zipWithIndex.map { case (value, col) =>
            if ((start to end) contains col + 1) 1
            else value
          }
        }

      val p0: Point = Point(0, (MAX_WIDTH - 1) / 2)
      val p1: Point = Point(MAX_HEIGHT - 1, 0)
      val p2: Point = Point(MAX_HEIGHT - 1, MAX_WIDTH - 1)
      val initTriangle: Triangle = Triangle(p0, p1, p2)

      val resultMatrix: Matrix = updateMatrix(solve(1, maxIter, Seq(initTriangle)), matrix)

      printMatrix(resultMatrix)
    }
  }

  def main(args: Array[String]): Unit = {

    val N: Int = io.StdIn.readLine().trim.toInt

    Solution.apply(N)
  }
}
