package hr.oknivk.aoc.aoc2018.day6

import hr.oknivk.aoc.common.{Config, Day}

import scala.util.matching.Regex

class Day6(config: Config) extends Day(config: Config) {
  def mapToPos(str: String): Position = {
    val res = new Regex("\\d+").findAllIn(str).map(_.toInt)
    Position(res.next, res.next)
  }

  override protected def part1(input: List[String]): String = {
    val in = input.map(mapToPos)
    val areas = getAreas(in)
    areas.maxBy(_._2)._2.toString
  }

  private def getAreas(in: List[Position]): Map[Position, Int] = {
    val minX = in.minBy(_.x).x
    val maxX = in.maxBy(_.x).x
    val minY = in.minBy(_.y).y
    val maxY = in.maxBy(_.y).y

    val vals = for {
      x <- minX to maxX
      y <- minY to maxY

      p = Position(x, y)

      dist = in.map(p.distance).min
      c = in.filter(p.distance(_) == dist)
      if c.length == 1
    } yield (p, c.head)

    vals.groupBy(_._2).mapValues(_.map(_._1)).filterNot(p => p._2.exists(c => c.x == minX || c.x == maxX || c.y == minY || c.y == maxY)).mapValues(_.size)
  }

  override protected def part2(input: List[String]): String = {
    val in = input.map(mapToPos)
    regionSize(in, 10000).toString
  }

  private def regionSize(in: List[Position], s: Int): Int = {
    val minX = in.minBy(_.x).x
    val maxX = in.maxBy(_.x).x
    val minY = in.minBy(_.y).y
    val maxY = in.maxBy(_.y).y

    val vals = for {
      x <- minX to maxX
      y <- minY to maxY

      p = Position(x, y)

      dist = in.map(p.distance).sum
      if dist < s
    } yield p

    vals.size

  }

  case class Position(x: Int, y: Int) {
    def distance(other: Position): Int = {
      Math.abs(x - other.x) + Math.abs(y - other.y)
    }
  }
}
