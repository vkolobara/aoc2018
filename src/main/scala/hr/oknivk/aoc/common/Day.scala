package hr.oknivk.aoc.common

class Day(config: Config, part1: Solution, part2: Solution) {

  val api: API = API.fromConfig(config)

  def run(): Unit = {
    api.submitAnswer(part1.solve(api.input), part2.solve(api.input))
  }

}
