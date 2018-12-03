package hr.oknivk.aoc.aoc2018.day3

import hr.oknivk.aoc.common.Solution

class Part1 extends Solution{

  override def solve(input: List[String]): String = {
    val i = input.map(in => in.split(' '))

    val res = i.map(in => {
      val pos = in(2).dropRight(1).split(",").map(_.toInt)
      val size = in(3).split("x").map(_.toInt)

      Rectangle(pos(0), pos(0) + size(0)-1, pos(1), pos(1) + size(1)-1)
    }).foldLeft(Map.empty[(Int, Int), Boolean])((m, rec) => rec.updateMap(m)).values.count(_ == true)

    res.toString
  }

  private case class Rectangle(l: Int, r: Int, t: Int, b: Int) {
    def updateMap(m: Map[(Int, Int), Boolean]): Map[(Int, Int), Boolean] = {
      (for {
        x <- l to r
        y <- t to b
      } yield (x, y)).foldLeft(m)((ma, k) => ma + (k -> ma.contains(k)))

    }
  }

}
