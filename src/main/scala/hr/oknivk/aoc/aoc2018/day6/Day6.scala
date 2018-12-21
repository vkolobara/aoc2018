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
    println(in.length)
    println(getCandidates(in).length)
    println(getDistances(in))

    ""
  }

  def getDistances(input: List[Position]): Map[(Position, Position), Int] = {
    (for {
      p1 <- input
      p2 <- input
      if p1 != p2
    } yield (p1, p2) -> p1.distance(p2)).toMap
  }

  def getCandidates(input: List[Position]): List[Position] = {
    val minX = input.minBy(_.x).x
    val minY = input.minBy(_.y).y
    val maxX = input.maxBy(_.x).x
    val maxY = input.maxBy(_.y).y

    input.filterNot(v => v.x == minX || v.x == maxX || v.y == minY || v.y == maxY)
  }

  override protected def part2(input: List[String]): String = ""

  case class Position(x: Int, y: Int) {
    def distance(other: Position): Int = {
      Math.abs(x - other.x) + Math.abs(y - other.y)
    }
  }
}
