lazy val root = project
  .in(file("."))
  .settings(
    name := "aoc-2018",
    version := "1.0.0",

  scalaVersion := "2.12.6",

  libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.4.1",
  libraryDependencies += "com.typesafe" % "config" % "1.3.2",
  )
