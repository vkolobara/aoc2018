package hr.oknivk.aoc.common

abstract class Day(config: Config){

  val api: API = API.fromConfig(config)

  protected def part1(input: List[String]): String
  protected def part2(input: List[String]): String

  def run(): Unit = {
    api.submitAnswer(part1(api.input), part2(api.input))
  }

}
