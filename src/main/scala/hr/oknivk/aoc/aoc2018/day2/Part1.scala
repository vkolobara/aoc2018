package hr.oknivk.aoc2018.day2

import hr.oknivk.aoc2018.common.Solution

class Part1 extends Solution{
  override def name: String = "day2-part1"

  override def solve(input: List[String]): String = {
    val x = input.map(i => {
      val tmp = i.sorted.groupBy(identity).mapValues(_.length).values.toSet[Int]
      (tmp.contains(2), tmp.contains(3))
    })
    val res = x.foldLeft((0, 0))((acc, vals) => (acc._1 + boolToInt(vals._1), acc._2 + boolToInt(vals._2)))
    (res._1 * res._2).toString
  }

  private def boolToInt(bool: Boolean): Int = if (bool) {
    1
  } else {
    0
  }
}
