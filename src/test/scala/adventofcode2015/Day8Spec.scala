package adventofcode2015

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Day8Spec extends AnyWordSpec with Matchers {
  "calculateCharDiff" should {
    "calculate the difference between chars for string literals and chars in memory" in {
      val strings = List("", "abc", "aaa\"aaa", "\x27")

      Day8.calculateCharDiff(strings) shouldBe 12
    }
  }
}
