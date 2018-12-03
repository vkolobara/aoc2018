package hr.oknivk.aoc2018.common

import java.io.{File, PrintWriter}
import java.nio.file.{Files, Path, Paths}

import io.Source._
import scalaj.http.Http


class API(basePath: String, year: Int, day: Int, cookie: String) {

  private val url = f"https://adventofcode.com/$year%d/day/$day%d/input"
  private val client = Http(url)
  private lazy val inputPath = Array(basePath, "input", year.toString, day.toString).mkString(File.separator)
  private lazy val outputPath = Array(basePath, "output", year.toString, day.toString).mkString(File.separator)

  Files.createDirectories(Paths.get(inputPath))
  Files.createDirectories(Paths.get(outputPath))

  private def downloadInput(downloadPath: String, year: Int, day: Int): Unit = {
    client.header("cookie", cookie)
    val w = new PrintWriter(downloadPath)
    w.write(client.asString.body)
    w.close()
  }

  private def readInput(path: String): List[String] = {
    fromFile(path).getLines.toList
  }

  def getData: List[String] = {
    if (!new File(inputPath).exists) {
      downloadInput(inputPath, year, day)
    }
    readInput(inputPath)
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
