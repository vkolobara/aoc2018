package hr.oknivk.aoc.common

import java.io.{File, PrintWriter}
import java.nio.file.{Files, Path, Paths}

import io.Source._
import scalaj.http.Http


class API(basePath: String, year: Int, day: Int, cookie: String) {

  private val url = f"https://adventofcode.com/$year%d/day/$day%d/input"
  private val client = Http(url).header("cookie", cookie)
  private lazy val inputPath = Array(basePath, year.toString, "input", day.toString).mkString(File.separator)
  private lazy val outputPath = Array(basePath, year.toString, "output", day.toString).mkString(File.separator)

  Files.createDirectories(Paths.get(inputPath).getParent)
  Files.createDirectories(Paths.get(outputPath))

  private def downloadInput(): Unit = {
    val w = new PrintWriter(inputPath)
    w.write(client.asString.body)
    w.close()
  }

  private def readInput(): List[String] = {
    fromFile(inputPath).getLines.toList
  }

   lazy val input: List[String] = {
    if (!Files.exists(Paths.get(inputPath))) {
      downloadInput()
    }
    readInput()
  }

  private def writeToDisk(part1: String, part2: String): Unit = {
    new PrintWriter(outputPath + File.separator + "part1") {write(part1); close()}
    new PrintWriter(outputPath + File.separator + "part2") {write(part2); close()}
  }

  def submitAnswer(part1: String, part2: String): Unit = {
    println("Part 1: " + part1)
    println("Part 2: " + part2)
    writeToDisk(part1, part2)
  }

}

object API {
  def fromConfig(config: Config): API = {
    new API(config.basePath, config.year, config.day, config.cookie)
  }
}
