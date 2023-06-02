package br.com.thiagotjuliao.introduction

object ComputeThePerimeterOfAPolygon {
  /**
   * You are given the cartesian coordinates of a set of points in a 2D plane.
   * When traversed sequentially, these points form a Polygon, P, which is not self-intersecting in nature.
   * Can you compute the perimeter of polygon P?
   */
  def main(args: Array[String]): Unit = {
    case class Point(x: Int, y: Int)

    def getPointFromStdIn: Point = {
      val input: Array[Int] = io.StdIn.readLine().trim.split(" ").map(_.toInt)

      Point(input(0), input(1))
    }

    def D(p1: Point, p2: Point): Double = {
      val deltaX: Double = Math.pow(p1.x - p2.x, 2)
      val deltaY: Double = Math.pow(p1.y - p2.y, 2)

      Math.sqrt(deltaX + deltaY)
    }

    val N: Int = io.StdIn.readLine().trim.toInt
    val points: Vector[Point] = (1 to N).map(_ => getPointFromStdIn).toVector

    val P: Double = points.zipWithIndex.collect {
      case (p: Point, idx: Int) if idx == N - 1 => D(p, points(0))
      case (p: Point, idx: Int) => D(p, points(idx + 1))
    }.sum

    println(BigDecimal(P).setScale(1, BigDecimal.RoundingMode.HALF_UP).toDouble)
  }
}
