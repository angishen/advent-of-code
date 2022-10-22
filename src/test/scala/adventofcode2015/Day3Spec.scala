package adventofcode2015

import adventofcode2015.Day3.{numHousesDelivered, numHousesDeliveredTailRec, twoSantasHousesDelivered}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Day3Spec extends AnyWordSpec with Matchers {
  "numHousesDelivered" should {
    "calculate the number of houses santa delivers at least one present to" in {
      val input1 = ">"
      val input2 = "^>v<"
      val input3 = "^v^v^v^v^v"
      val input4 = "^^^^^"

      numHousesDelivered(input1) shouldBe 2
      numHousesDelivered(input2) shouldBe 4
      numHousesDelivered(input3) shouldBe 2
      numHousesDelivered(input4) shouldBe 6
    }
  }
  "numHousesDeliveredTailRec" should {
    "calculate the number of houses santa delivers at least one present to" in {
      val input1 = ">"
      val input2 = "^>v<"
      val input3 = "^v^v^v^v^v"
      val input4 = "^^^^^"

      numHousesDeliveredTailRec(input1) shouldBe 2
      numHousesDeliveredTailRec(input2) shouldBe 4
      numHousesDeliveredTailRec(input3) shouldBe 2
      numHousesDelivered(input4) shouldBe 6
    }
  }
  "numHousesTwoSantas" should {
    "calculate the number of houses santa and robosanta deliver presents to" in {
      val input1 = "^v"
      val input2 = "^>v<"
      val input3 = "^v^v^v^v^v^"

      twoSantasHousesDelivered(input1) shouldBe 3
      twoSantasHousesDelivered(input2) shouldBe 3
      twoSantasHousesDelivered(input3) shouldBe 12

    }
  }
}
