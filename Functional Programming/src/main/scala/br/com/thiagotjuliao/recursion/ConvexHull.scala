package br.com.thiagotjuliao.recursion

import scala.annotation.tailrec

object ConvexHull {
  /**
   * Convex Hull of a set of points, in 2D plane, is a convex polygon with minimum area such that each point lies either on the boundary of polygon or inside it.
   *
   * Let's consider a 2D plane, where we plug pegs at the points mentioned.
   * We enclose all the pegs with a elastic band and then release it to take its shape.
   * The closed structure formed by elastic band is similar to that of convex hull.
   *
   * Given a set of N points, Find the perimeter of the convex hull for the points.
   *
   * The solution uses the Graham Scan approach: https://algorithmtutor.com/Computational-Geometry/Convex-Hull-Algorithms-Graham-Scan/
   */
  case class Point(x: Int, y: Int) {
    def dist(other: Point): Double = {
      val dx: Double = Math.pow(this.x - other.x, 2)
      val dy: Double = Math.pow(this.y - other.y, 2)

      Math.sqrt(dx + dy)
    }
  }

  object Point {
    final val ORIGIN: Point = Point(0, 0)

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

  object Polygon {
    def perimeter(points: Vector[Point]): Double =
      points.zipWithIndex.collect {
        case (p: Point, idx: Int) if idx == points.length - 1 => p.dist(points(0))
        case (p: Point, idx: Int) => p.dist(points(idx + 1))
      }.sum
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

    println("> Input points")
    printPoints(points)

    println("> Finding the first point with the smallest y-coordinate")
    val p0: Point = points.sorted(bottomMostOrdering).head
    println(p0 + "\n")

    println("> Sorting points based on the polar angle relative to P0")
    val polarSortedPoints: Vector[Point] = points.tail.sorted(polarOrdering(p0))
    printPoints(polarSortedPoints)

    println("> Removing collinear points keeping the farthest point")
    val cleanedSortedPoints: Vector[Point] = polarSortedPoints.zipWithIndex.collect {
      case (p, idx) if idx < polarSortedPoints.length - 1 && orientation(p0, p, polarSortedPoints(idx + 1)) != 0 => p
      case (p, idx) if idx == polarSortedPoints.length - 1 => p
    }
    printPoints(cleanedSortedPoints)

    println("> Initial Convex Hull Stack")
    val initialStack: Vector[Point] = cleanedSortedPoints.take(2).reverse :+ p0
    printPoints(initialStack)

    @tailrec
    def acceptAndRejectPoints(next: Point, stack: Vector[Point]): Vector[Point] = {
      val tops: Vector[Point] = stack.take(2)
      val curr: Point = tops(0)
      val prev: Point = tops(1)

      if (orientation(prev, curr, next) == 2) // Left Turn
        next +: stack
      else
        acceptAndRejectPoints(next, stack.drop(1))
    }

    println("> Building the Convex Hull Stack")
    val finalStack: Vector[Point] = cleanedSortedPoints.drop(2)
      .foldLeft(initialStack) { case (stack, p) =>
        val tops: Vector[Point] = stack.take(2)

        print(p + " " + orientation(tops(1), tops(0), p) + " ")
        printPoints(stack)

        acceptAndRejectPoints(p, stack)
      }

    printPoints(finalStack)

    println("> Printing the perimeter of the Convex Hull")
    println(Polygon.perimeter(finalStack))
  }
}
