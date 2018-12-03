package hr.oknivk.aoc2018.day3

import hr.oknivk.aoc2018.common.Solution

class Part2 extends Solution{
  override def name: String = "day3-part2"

  override def solve(input: List[String]): String = {
    val i = input.map(in => in.split(' '))

    val rectangles = i.map(in => {
      val id = in(0).drop(1)
      val pos = in(2).dropRight(1).split(",").map(_.toInt)
      val size = in(3).split("x").map(_.toInt)

      Rectangle(id, pos(0), pos(0) + size(0)-1, pos(1), pos(1) + size(1)-1)
    })

    val m = rectangles.foldLeft(Map.empty[(Int, Int), Boolean])((m, rec) => rec.updateMap(m))

    val res = rectangles.find(rec => rec.checkOverlapping(m))


    res.get.id.toString
  }

  private case class Rectangle(id: String, l: Int, r: Int, t: Int, b: Int) {
    def updateMap(m: Map[(Int, Int), Boolean]): Map[(Int, Int), Boolean] = {
      (for {
        x <- l to r
        y <- t to b
      } yield (x, y)).foldLeft(m)((ma, k) => ma + (k -> ma.contains(k)))
    }

    def checkOverlapping(m: Map[(Int, Int), Boolean]): Boolean = {
      !(for {
        x <- l to r
        y <- t to b
      } yield (x, y)).foldLeft(false)((acc, k) => acc || m(k))
    }
  }
}
