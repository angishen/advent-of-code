package adventofcode2015

import adventofcode2015.Day1._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Day1Spec extends AnyWordSpec with Matchers {
  "getBasementPosition" should {
    "return the correct basement index" in {
      val input1 = ")"
      val input2 = "()())"

      getBasementPosition(input1) shouldBe 1
      getBasementPosition(input2) shouldBe 5
    }
  }
  "getBasementPositionTailRec" should {
    "return the correct basement index" in {
      val input1 = ")"
      val input2 = "()())"

      getBasementPositionTailRec(input1) shouldBe 1
      getBasementPositionTailRec(input2) shouldBe 5
    }
  }
}
