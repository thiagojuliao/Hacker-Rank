package br.com.thiagotjuliao.recursion

object RecursiveTrees {
  /**
   * This challenge involves the construction of trees, in the form of ASCII Art.
   * The restriction is, that you need to accomplish this with functional programming, and you cannot declare even local variables!
   *
   * We have to deal with real world constraints, so we cannot keep repeating the pattern infinitely.
   * So, we will provide you a number of iterations, and you need to generate the ASCII version of the Fractal Tree for only those many iterations (or, levels of recursion)
   */
  object Config {
    final val MAX_HEIGHT: Int = 63
    final val MAX_WIDTH: Int = 100
  }

  sealed trait TreePoint {
    val x: Int
    val y: Int
  }

  case class RootPoint(x: Int, y: Int) extends TreePoint
  case class BranchPoint(x: Int, y: Int) extends TreePoint
  case class LeafPoint(x: Int, y: Int) extends TreePoint

  sealed trait Tree[+T] {
    val root: T
    val size: Int

    def surface: Seq[T]
  }

  case class EmptyTree() extends Tree[Nothing] {
    override lazy val root: Nothing =
      throw new RuntimeException("Cannot build a tree without a root")

    override val size: Int = 0

    override def surface: Seq[Nothing] = Seq.empty
  }

  case class LivingTree private (root: RootPoint, size: Int) extends Tree[TreePoint] {
    lazy val A: BranchPoint = BranchPoint(root.x - 1, root.y)
    lazy val B: BranchPoint = BranchPoint(A.x - size + 1, A.y)
    lazy val C: LeafPoint = LeafPoint(A.x - 2 * size + 1, A.y - size)
    lazy val D: LeafPoint = LeafPoint(A.x - 2 * size + 1, A.y + size)

    override def surface: Seq[TreePoint] = {
      val top: Seq[TreePoint] = (0 until size).flatMap { h =>
        val C_ : BranchPoint = BranchPoint(C.x + h, C.y + h)
        val D_ : BranchPoint = BranchPoint(D.x + h, D.y - h)

        Seq(C_, D_)
      }

      val bottom: Seq[TreePoint] = (0 until size).flatMap { h =>
        val B_ : BranchPoint = BranchPoint(B.x + h, B.y)

        Seq(B_)
      }

      top ++ bottom
    }
  }

  object Tree {
    def buildFrom(tp: TreePoint, size: Int): LivingTree = tp match {
      case r: RootPoint => LivingTree(r, size)
      case BranchPoint(x, y) => LivingTree(RootPoint(x + 1, y), size)
      case LeafPoint(x, y) => LivingTree(RootPoint(x, y), size)
    }
  }

  object Matrix {
    type Matrix = Array[Array[Int]]

    def printMatrix(matrix: Matrix): Unit =
      matrix.foreach { row =>
        val rowS: String = row.mkString.replace("0", "_")

        println(rowS)
      }

    def updateMatrix(trees: Seq[LivingTree], matrix: Matrix): Matrix = {
      val surface: Seq[TreePoint] = trees.flatMap(_.surface)

      matrix.zipWithIndex.map { case (line, lidx) =>
        line.indices.map { cidx =>
          val point: BranchPoint = BranchPoint(lidx, cidx)

          if (surface contains point) 1
          else 0
        }.toArray
      }
    }
  }

  object Solution {
    import Matrix._
    import Config._

    private def solve(iter: Int, maxIter: Int, parentTree: LivingTree, acc: Seq[LivingTree]): Seq[LivingTree] = {
      if (maxIter == 1) Seq(parentTree)
      else if (iter > maxIter) acc
      else {
        val childTree00: LivingTree = Tree.buildFrom(parentTree.C, parentTree.size / 2)
        val childTree01: LivingTree = Tree.buildFrom(parentTree.D, parentTree.size / 2)

        solve(iter + 1, maxIter, childTree00, childTree00 +: parentTree +: acc) ++
        solve(iter + 1, maxIter, childTree01, childTree01 +: acc)
      }
    }

    def apply(maxIter: Int): Unit = {
      val matrix: Matrix = Array.ofDim[Int](MAX_HEIGHT, MAX_WIDTH)

      val initRoot: RootPoint = RootPoint(MAX_HEIGHT, MAX_WIDTH / 2 - 1)
      val initParent: LivingTree = Tree.buildFrom(initRoot, 16)

      val resultTrees: Seq[LivingTree] = solve(2, maxIter, initParent, Seq())
      val resultMatrix: Matrix = updateMatrix(resultTrees, matrix)

      printMatrix(resultMatrix)
    }
  }

  def main(args: Array[String]): Unit = {
    val N: Int = io.StdIn.readLine().trim.toInt

    Solution.apply(N)
  }
}
