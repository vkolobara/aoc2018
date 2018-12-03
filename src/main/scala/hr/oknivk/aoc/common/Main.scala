package hr.oknivk.aoc.common

object Main {
  def main(args: Array[String]): Unit = {
    val conf = new Config
    val part1 = Class.forName(f"hr.oknivk.aoc.aoc${conf.year}%d.day${conf.day}%d.Part1").newInstance().asInstanceOf[Solution]
    val part2 = Class.forName(f"hr.oknivk.aoc.aoc${conf.year}%d.day${conf.day}%d.Part2").newInstance().asInstanceOf[Solution]

    new Day(conf, part1, part2).run()
  }
}
