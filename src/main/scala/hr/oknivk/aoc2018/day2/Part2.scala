package hr.oknivk.aoc2018.day2

import hr.oknivk.aoc2018.common.Solution

class Part2 extends Solution{
  override def name: String = "day2-part2"

  override def solve(input: List[String]): String = {
    val res = cross(input, input.tail).find(i => diff(i._1, i._2).length == 1)

    if (res.isDefined) res.get._1 intersect res.get._2
    else ""
  }

  private def diff(x1: String, x2: String): IndexedSeq[Char] = {
    for {
      i <- 0 until x1.length
      if x1(i) != x2(i)
    } yield x1(i)
  }

  private def cross(x1: List[String], x2: List[String]): List[(String, String)] = {
    for {
      x <- x1
      y <- x2
    } yield (x,y)
  }
}
