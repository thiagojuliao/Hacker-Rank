package br.com.thiagotjuliao.introduction

object ComputeTheAreaOfAPolygon {
  /**
   * You are given the cartesian coordinates of a set of points in a 2D plane.
   * When traversed sequentially, these points form a Polygon, P, which is not self-intersecting in nature.
   * Can you compute the area of polygon P?
   */
  def main(args: Array[String]): Unit = {
    case class Point(x: Int, y: Int)

    def getPointFromStdIn: Point = {
      val input: Array[Int] = io.StdIn.readLine().trim.split(" ").map(_.toInt)

      Point(input(0), input(1))
    }

    def combine(p1: Point, p2: Point): Double =
      p1.x * p2.y - p1.y * p2.x

    val N: Int = io.StdIn.readLine().trim.toInt
    val points: Vector[Point] = (1 to N).map(_ => getPointFromStdIn).toVector

    val A: Double = Math.abs(
      points.zipWithIndex.collect {
        case (p: Point, idx: Int) if idx == N - 1 => combine(p, points(0))
        case (p: Point, idx: Int) => combine(p, points(idx + 1))
      }.sum
    ) / 2

    println(BigDecimal(A).setScale(1, BigDecimal.RoundingMode.HALF_UP).toDouble)
  }
}
