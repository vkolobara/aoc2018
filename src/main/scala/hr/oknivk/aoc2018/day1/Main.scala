package hr.oknivk.aoc2018.day1

import hr.oknivk.aoc2018.common.{AOC, Solver}

object Main {
  def main(args: Array[String]): Unit = {
    if (AOC.checkArgs(args)) {
      AOC.runDay(args(0), args(1), new Solver(new Part1), new Solver(new Part2))
    } else {
      Console.err.println("Input and output path must be provided!")
    }
  }
}
