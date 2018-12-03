package hr.oknivk.aoc2018.day3

import hr.oknivk.aoc2018.common.{AOC, Solver}

object Main {
  def main(args: Array[String]): Unit = {
    AOC.runDay(args(0), args(1), new Solver(new Part1), new Solver(new Part2))
  }
}
