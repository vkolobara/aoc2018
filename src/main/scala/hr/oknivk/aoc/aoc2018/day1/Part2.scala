package hr.oknivk.aoc.aoc2018.day1

import hr.oknivk.aoc.common.Solution

class Part2 extends Solution {
  override def solve(input: List[String]): String = {
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
