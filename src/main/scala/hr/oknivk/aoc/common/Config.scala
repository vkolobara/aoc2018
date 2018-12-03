package hr.oknivk.aoc2018.common

import com.typesafe.config
import com.typesafe.config.{Config, ConfigFactory}

class Config {
  private val conf: config.Config = ConfigFactory.load()

  lazy val basePath: String = conf.getString("aoc.basePath")
  lazy val year: Int = conf.getInt("aoc.year")
  lazy val day: Int = conf.getInt("aoc.day")
  lazy val cookie: String = conf.getString("aoc.cookie")
}
