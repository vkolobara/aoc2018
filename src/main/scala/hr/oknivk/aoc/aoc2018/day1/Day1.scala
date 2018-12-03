package hr.oknivk.aoc.aoc2018.day1

import hr.oknivk.aoc.common.{Config, Day}

class Day1(config: Config) extends Day(config: Config) {

  override protected def part1(input: List[String]): String = input.map(_.toInt).sum.toString

  override protected def part2(input: List[String]): String = {
    def f(freqs: Stream[Int], visited: Set[Int]): Int = {
      if (visited.contains(freqs.head)) {
        freqs.head
      } else {
        f(freqs.tail, visited + freqs.head)
      }
    }

    f(Stream.continually(input.map(_.toInt).toStream).flatten.scan(0)(_ + _), Set.empty[Int]).toString
  }

}
