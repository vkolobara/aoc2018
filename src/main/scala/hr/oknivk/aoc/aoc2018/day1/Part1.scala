package hr.oknivk.aoc.aoc2018.day1

import hr.oknivk.aoc.common.Solution

class Part1 extends Solution{
  override def solve(input: List[String]): String = input.map(_.toInt).sum.toString
}
