package hr.oknivk.aoc2018.common

import java.io.PrintWriter

import scala.io.Source._

object AOC {

  def checkArgs(args: Array[String]): Boolean = {
    args.length == 2
  }

  def readInput(path: String): List[String] = {
    fromFile(path).getLines.toList
  }

  def writeOutput(result: String, path: String): Unit = {
    val writer = new PrintWriter(path)
    writer.write(result)
    writer.close()
  }

  def runDay(inputPath: String, outputPath: String, part1: Solver, part2: Solver): Unit = {
    part1.solve(inputPath, outputPath)
    part2.solve(inputPath, outputPath)
  }

}
