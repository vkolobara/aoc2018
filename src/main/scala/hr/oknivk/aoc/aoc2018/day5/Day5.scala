package hr.oknivk.aoc.aoc2018.day5

import hr.oknivk.aoc.common.{Config, Day}

class Day5(config: Config) extends Day(config: Config){

  override protected def part1(input: List[String]): String = {
    f1(input.head).length.toString
  }

  def f1(in: String): String = {
    val s = removeDuplicates(in)
    if (s.length == in.length) in
    else f1(s)
  }
  def removeDuplicates(in: String): String = {
    in.foldRight("")((c, s) => if (!s.isEmpty && Math.abs(c - s.head) == 32) s.tail else c.toString + s)
  }

  override protected def part2(input: List[String]): String = {
    val in = input.head
    val letters = in.map(_.toLower).distinct
    val res = letters.map(c => f1(in.replaceAll(c.toString, "").replaceAll(c.toUpper.toString, "")).length).min
    res.toString
  }
}
