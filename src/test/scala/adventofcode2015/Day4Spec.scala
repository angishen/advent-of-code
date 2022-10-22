package adventofcode2015

import adventofcode2015.Day4.getResultForKey
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Day4Spec extends AnyWordSpec with Matchers {
  "getResultForKey" should {
    "return the correct number given a secret key" in {
      val input1 = "abcdef"
      val input2 = "pqrstuv"

      getResultForKey(input1) shouldBe 609043
      getResultForKey(input2) shouldBe 1048970

    }
  }
}
