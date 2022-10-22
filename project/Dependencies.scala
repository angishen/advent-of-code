import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.2.9"

  lazy val testDependencies = Seq(
    scalaTest,
  ).map(_ % "test")
}
