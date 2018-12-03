package hr.oknivk.aoc.aoc2018.day2

import hr.oknivk.aoc.common.{Config, Day}

class Day2(config: Config) extends Day(config: Config){

  override protected def part1(input: List[String]): String = {
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

  override protected def part2(input: List[String]): String = {
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
