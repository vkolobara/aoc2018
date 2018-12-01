package hr.oknivk.aoc2018.common

class Solver(solution: Solution) {
  def solve(inputPath: String, outputPath: String): Unit = {
    AOC.writeOutput(solution.solve(AOC.readInput(inputPath)), outputPath.concat(solution.name))
  }
}
