package hr.oknivk.aoc.common

//noinspection ScalaDeprecation
object Main {
  def main(args: Array[String]): Unit = {
    val config = new Config
    val day: Day = Class.forName(f"hr.oknivk.aoc.aoc${config.year}%d.day${config.day}%d.Day${config.day}%d").getConstructor(classOf[Config]).newInstance(new Config).asInstanceOf[Day]
    day.run()
  }
}
