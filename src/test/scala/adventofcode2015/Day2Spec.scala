package adventofcode2015

import adventofcode2015.Day2.{Box, getTotalArea, getTotalRibbonLength}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Day2Spec extends AnyWordSpec with Matchers {
  "getTotalArea" should {
    "calculate the total surface area of a list of boxes" in {
      val boxes = List(Box(2, 3, 4), Box(1,1,10))

      getTotalArea(boxes) shouldBe 58 + 43
    }
  }

  "getTotalRibbonLength" should {
    "calculate the total ribbon length needed for a list of boxes" in {
      val boxes = List(Box(2, 3, 4), Box(1,1,10))

      getTotalRibbonLength(boxes) shouldBe 34 + 14
    }
  }
}
