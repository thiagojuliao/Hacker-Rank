package br.com.thiagotjuliao.introduction

import scala.annotation.tailrec

object AreaUnderCurvesAndVolumeOfRevolvingACurve {
  /**
   * The first line contains N integers separated by spaces, which are the values of a1,a2,...,an.
   * The second line contains N integers separated by spaces, which are the values of b1,b2,...,bn.
   * The third line contains two space separated integers,  and , the lower and upper range limits in which the integration needs to be performed, respectively.
   */
  def main(args: Array[String]): Unit = {
    // This function will be used while invoking "Summation" to compute
    // The area under the curve.
    def f(coefficients: List[Int], powers: List[Int], x: Double): Double = {
      //Fill Up this function body
      // To compute the value of the function
      // For the given coefficients, powers and value of x
      coefficients.zip(powers).map { case (c, p) =>
        c * Math.pow(x, p)
      }.sum
    }

    // This function will be used while invoking "Summation" to compute
    // The Volume of revolution of the curve around the X-Axis
    // The 'Area' referred to here is the area of the circle obtained
    // By rotating the point on the curve (x,f(x)) around the X-Axis
    def area(coefficients: List[Int], powers: List[Int], x: Double): Double = {
      //Fill Up this function body
      // To compute the area of the circle on revolving the point
      // (x,f(x)) around the X-Axis
      // For the given coefficients, powers and value of x
      val Fx = f(coefficients, powers, x)

      Math.PI * Math.pow(Fx, 2)
    }

    // This is the part where the series is summed up
    // This function is invoked once with func = f to compute the area 	     // under the curve
    // Then it is invoked again with func = area to compute the volume
    // of revolution of the curve
    def summation(func: (List[Int], List[Int], Double) => Double, upperLimit: Int, lowerLimit: Int, coefficients: List[Int], powers: List[Int]): Double = {
      // Fill up this function

      @tailrec
      def summingUp(x: Double, acc: Double): Double = {
        if (x > upperLimit) acc
        else summingUp(x + 0.001, acc + func(coefficients, powers, x) * 0.001)
      }

      BigDecimal(summingUp(lowerLimit, 0.0)).setScale(1, BigDecimal.RoundingMode.HALF_UP).toDouble
    }

    val lowerLimit: Int = 1
    val upperLimit: Int = 4
    val coefficients: List[Int] = List(1, 2, 3, 4, 5)
    val powers: List[Int] = List(6, 7, 8, 9, 10)

    println(summation(f, upperLimit, lowerLimit, coefficients, powers))
    println(summation(area, upperLimit, lowerLimit, coefficients, powers))
  }
}
