import sbt._

object Dependencies {
  val scalaTest = "org.scalatest" %% "scalatest" % "3.2.9"

  // libraries
  val ScalaParserCombinators = "org.scala-lang.modules" %% "scala-parser-combinators" % "2.1.1"

  val circeVersion = "0.14.1"

  val circeDependencies = Seq(
    "io.circe" %% "circe-core",
    "io.circe" %% "circe-generic",
    "io.circe" %% "circe-parser"
  ).map(_ % circeVersion)

  val dependencies = Seq(
    ScalaParserCombinators
  )

  val testDependencies = Seq(
    scalaTest,
  ).map(_ % "test")

  val allDependencies = dependencies ++ testDependencies ++ circeDependencies
}
