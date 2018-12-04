package hr.oknivk.aoc.aoc2018.day4

import hr.oknivk.aoc.common.{Config, Day}

import scala.util.matching.Regex

class Day4(config: Config) extends Day(config: Config){

  def parseRow(row: String) = {

  }

  override protected def part1(input: List[String]): String = {
    val regex = new Regex("\\d{4}-\\d{2}-\\d{2} \\d{2}")
    GuardDay.fromRow(input.groupBy(regex.findFirstIn(_).get).mapValues(_.sorted))
    ""
  }

  override protected def part2(input: List[String]): String = {
    ""
  }

  case class GuardDay(id: Int, date: String, m: Map[Int, Boolean])
  object GuardDay {
    def fromRow(row: List[String]): GuardDay = {
      val idRegex = new Regex("#\\d{4}")
      val id = idRegex.findFirstIn(row.head).get.toInt
      val dateRegex = new Regex("\\d{2}-\\d{2} ")
      val date = dateRegex.findFirstIn(row.head).get

      GuardDay(id, date, m)
    }
  }
  trait Action

}
