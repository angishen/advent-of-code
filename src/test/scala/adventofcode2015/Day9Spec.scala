package adventofcode2015

import adventofcode2015.Day9.{TripLeg, shortestPath}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Day9Spec extends AnyWordSpec with Matchers {
  "shortestPath" should {
    "find the shortest path in a weighted graph visiting all nodes" in {
      val input = List(
        TripLeg("London", "Dublin", 464),
        TripLeg("London", "Belfast", 518),
        TripLeg("Dublin", "Belfast", 141),
      )
    }
  }
}
