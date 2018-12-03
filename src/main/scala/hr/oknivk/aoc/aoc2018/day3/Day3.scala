package hr.oknivk.aoc.aoc2018.day3

import hr.oknivk.aoc.common.{Config, Day}

import scala.util.matching.Regex

class Day3(config: Config) extends Day(config: Config){

  private def parseRow(regex: Regex)(row: String): Rectangle = {
     val in = regex.findAllIn(row).toArray.map(_.toInt)
     Rectangle(in(0).toString, in(1), in(1) + in(3), in(2), in(2) + in(4))
  }


  override protected def part1(input: List[String]): String = {
    val rectangles = input.map(parseRow(new Regex("\\d+")))

    val res = rectangles.foldLeft(Map.empty[(Int, Int), Boolean])((m, rec) => rec.updateMap(m)).values.count(_ == true)
    res.toString
  }

  override protected def part2(input: List[String]): String = {
    val rectangles = input.map(parseRow(new Regex("\\d+")))
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
