package adventofcode2015

import adventofcode2015.Day6._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Day6Spec extends AnyWordSpec with Matchers {
  "setupLights" should {
    "return the number of lights turned on" in {
      val input1 = List(InstructionStep(TurnOn, Coord(0,0), Coord(999, 999)))
      val input2 = List(InstructionStep(Toggle, Coord(0,0), Coord(999, 0)))
      val input3 = List(InstructionStep(TurnOff, Coord(499,499), Coord(500, 500)))

      setupLights(input1, Part1) shouldBe 1000000
      setupLights(input2, Part1) shouldBe 1000
      setupLights(input3, Part1) shouldBe 0
    }
  }

}
