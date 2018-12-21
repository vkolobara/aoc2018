package hr.oknivk.aoc.aoc2018.day4

import hr.oknivk.aoc.common.{Config, Day}

import scala.util.matching.Regex

class Day4(config: Config) extends Day(config: Config) {

  override protected def part1(input: List[String]): String = {
    val rows = f(List.empty, -1, input.sorted)
    rows.groupBy(_._1)
    ""
  }

  def f(l: List[(Int, Array[Int])], lastIndex: Int, rows: List[String]): List[(Int, Array[Int])] = rows match {
    case Nil => l
    case x::y::xs => {
      if (x.split("]")(1).trim.startsWith("Guard")) {
        val regex = new Regex("#\\d+")
        val lastIndex = regex.findFirstIn(x).get.drop(1).toInt
        f(l, lastIndex, y::xs)
      } else {
        val regex = new Regex(":\\d{2}")
        val minuteSleep = regex.findFirstIn(x).get.drop(1).toInt
        val minuteWake = regex.findFirstIn(y).get.drop(1).toInt

        f ((lastIndex, minuteSleep until minuteWake toArray) :: l, lastIndex, xs)
      }
    }
  }

  override protected def part2(input: List[String]): String = {
    ""
  }

  private def parseAction(r: String): (Int, Action) = {
    val reg = new Regex(":\\d{2}")
    val minute = reg.findFirstIn(r).get.tail.toInt
    if (r.endsWith("asleep")) {
      (minute, SleepAction)
    } else {
      (minute, WakeAction)
    }
  }

  trait Action

  object SleepAction extends Action

  object WakeAction extends Action

}
