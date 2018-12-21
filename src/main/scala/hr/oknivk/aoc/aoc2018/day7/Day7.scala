
package hr.oknivk.aoc.aoc2018.day7

import hr.oknivk.aoc.common.{Config, Day}

import scala.util.matching.Regex

class Day7(config: Config) extends Day(config: Config) {

  private def mapRow(row: String): (String, String) = {
    val sp = row.split(" ")
    (sp(1), sp(7))
  }

  override protected def part1(input: List[String]): String = {
      val in = input.map(mapRow)
      val tasks = in.flatMap(v => v._1 ++ v._2)
      val dependencies = in.map(x => (x._1.head, x._2.head)).groupBy(_._2).mapValues(_.map(_._1).toSet)
      val todo = (tasks.toSet &~ dependencies.keySet).toList.sorted
      f(todo, Set.empty[Char], dependencies)
  }

  private def f(todo: List[Char], visited: Set[Char], deps: Map[Char, Set[Char]]): String = todo match {
    case x::xs => {
        val visitedNew = visited + x
        val depsNew = deps.map(d => (d._1, d._2 - x)).filterNot(_._2.isEmpty)
        val todoNew = (xs ++ (deps.keySet &~ depsNew.keySet).toList).sorted
        x + f(todoNew, visitedNew, depsNew)
    }
    case _ => ""
  }

  override protected def part2(input: List[String]): String = {
      val in = input.map(mapRow)
      val tasks = in.flatMap(v => v._1 ++ v._2)
      val dependencies = in.map(x => (x._1.head, x._2.head)).groupBy(_._2).mapValues(_.map(_._1).toSet)
      val todo = (tasks.toSet &~ dependencies.keySet).toList.sorted
      (f2(Map.empty[Char, Int], todo, dependencies) - 1).toString
  }

  private def f2(current: Map[Char, Int], todo: List[Char], deps: Map[Char, Set[Char]]): Int =  {
      if (todo.isEmpty && current.isEmpty) 0
      else {
        var next = current.map(x => (x._1, x._2 - 1)).filter(_._2 > 0)
        val diff = current.keySet &~ next.keySet
        val depsNew = deps.map(d => (d._1, d._2 &~ diff)).filterNot(_._2.isEmpty)
        var todoNew = (todo ++ (deps.keySet &~ depsNew.keySet).toList).sorted

        if (next.size < 5) {
            val s = 5 - next.size
            next = next ++ todoNew.take(s).map(c => (c, 60 + c - 'A' + 1)).toMap
            todoNew = todoNew.drop(s)
        }

        1 + f2(next, todoNew, depsNew)
      }
  }
}
