package br.com.thiagotjuliao.recursion

import scala.annotation.tailrec

object ConcavePolygon {
  /**
   * You are given the cartesian coordinates of a set of points in a 2D plane (in no particular order).
   * Each of these points is a corner point of some Polygon, P, which is not self-intersecting in nature.
   * Can you determine whether or not P is a concave polygon?
   */
  case class Point(x: Int, y: Int) {
    def dist(other: Point): Double = {
      val dx: Double = Math.pow(this.x - other.x, 2)
      val dy: Double = Math.pow(this.y - other.y, 2)

      Math.sqrt(dx + dy)
    }

    def angleWith(prev: Point, next: Point): Double = {
      val orientation: Int = Point.orientation(prev, this, next)

      val v0: Vector2D = Vector2D.from(prev, this)
      val v1: Vector2D = Vector2D.from(this, next)

      val rad: Double = Math.acos(v0.product(v1) * 1.0 / (v0.modulo * v1.modulo))

      if (orientation != 2) (360 * Math.PI - rad) / Math.PI
      else 180 * rad / Math.PI
    }
  }

  object Point {
    val bottomMostOrdering: Ordering[Point] = (p1: Point, p2: Point) => {
      if (p1.y < p2.y) -1
      else if (p1.y > p2.y) 1
      else if (p1.x < p2.x) -1
      else 1
    }

    def orientation(p1: Point, p2: Point, p3: Point): Int = {
      val value: Int = (p2.y - p1.y) * (p3.x - p2.x) - (p2.x - p1.x) * (p3.y - p2.y)

      if (value == 0) 0 // Collinear
      else if (value > 0) 1 // Clockwise
      else 2 // Counter Clockwise
    }

    def polarOrdering(p0: Point): Ordering[Point] = (p1: Point, p2: Point) => {
      val orientation: Int = this.orientation(p0, p1, p2)

      if (orientation == 0) {
        if (p2.dist(p0) >= p1.dist(p0)) -1
        else 1
      }
      else if (orientation == 2) -1
      else 1
    }
  }

  case class Vector2D private (x: Int, y: Int) {
    final val modulo: Double = {
      val X: Double = Math.pow(x, 2)
      val Y: Double = Math.pow(y, 2)

      Math.sqrt(X + Y)
    }

    def product(other: Vector2D): Int =
      this.x * other.x + this.y * other.y
  }

  object Vector2D {
    def from(p0: Point, p1: Point): Vector2D =
      Vector2D(p1.x - p0.x, p1.y - p0.y)
  }

  def main(args: Array[String]): Unit = {
    import Point._

    def printPoints(points: Vector[Point]): Unit =
      println(points.mkString("[", ", ", "]\n"))

    val N: Int = io.StdIn.readLine().trim.toInt

    val points: Vector[Point] = (1 to N).map { _ =>
      val input: Array[Int] = io.StdIn.readLine().trim.split(" ").map(_.toInt)

      Point(input(0), input(1))
    }.toVector

    val sortedPoints: Vector[Point] = points.sorted(bottomMostOrdering)
    val p0: Point = sortedPoints.head

    val polarSortedPoints: Vector[Point] = p0 +: sortedPoints.tail.sorted(polarOrdering(p0))
    printPoints(polarSortedPoints)

    @tailrec
    def isConcavePolygon(idx: Int, points: Vector[Point], result: Boolean): Boolean = {
      if (idx == polarSortedPoints.length - 1) result
      else {
        val prev: Point = points(idx - 2)
        val curr: Point = points(idx - 1)
        val next: Point = points(idx)

        val teta: Double = curr.angleWith(prev, next)

        if (180 < teta && teta < 360)
          isConcavePolygon(idx + 1, points, result = true)
        else isConcavePolygon(idx + 1, points, result)
      }
    }

    val result: String = {
      if (isConcavePolygon(2, polarSortedPoints, result = false)) "YES"
      else "NO"
    }

    println(result)
  }
}
