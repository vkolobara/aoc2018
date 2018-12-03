package hr.oknivk.aoc2018.day1

import hr.oknivk.aoc2018.common.Solution

class Part1 extends Solution{
  override def name: String = "day1-part1"

  override def solve(input: List[String]): String = input.map(_.toInt).sum.toString
}
