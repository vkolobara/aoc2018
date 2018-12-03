package hr.oknivk.aoc2018.common

class RunDay(part1: Solution, part2: Solution) {

  def run (configAOC: Config): Unit = {
    val input = Util.getData(configAOC.inputPath, configAOC.year, configAOC.day)
    part1.solve(input)
    part2.solve(input)
  }

}
