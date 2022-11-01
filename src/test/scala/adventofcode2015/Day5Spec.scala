package adventofcode2015

import adventofcode2015.Day5.{isNiceString, isNiceStringPt2, isNiceStringTailRec, isNiceStringWithFolds}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Day5Spec extends AnyWordSpec with Matchers {
  "isNiceString" should {
    "check if a string is naughty or nice" in {
      val input1 = "ugknbfddgicrmopn"
      val input2 = "aaa"
      val input3 = "jchzalrnumimnmhp"
      val input4 = "haegwjzuvuyypxyu"
      val input5 = "dvszwmarrgswjxmb"

      isNiceString(input1) shouldBe true
      isNiceString(input2) shouldBe true
      isNiceString(input3) shouldBe false
      isNiceString(input4) shouldBe false
      isNiceString(input5) shouldBe false
    }
  }

  "isNiceStringTailRec" should {
    "check if a string is naughty or nice" in {
      val input1 = "ugknbfddgicrmopn"
      val input2 = "aaa"
      val input3 = "jchzalrnumimnmhp"
      val input4 = "haegwjzuvuyypxyu"
      val input5 = "dvszwmarrgswjxmb"

      isNiceStringTailRec(input1) shouldBe true
      isNiceStringTailRec(input2) shouldBe true
      isNiceStringTailRec(input3) shouldBe false
      isNiceStringTailRec(input4) shouldBe false
      isNiceStringTailRec(input5) shouldBe false
    }
  }

  "isNiceStringWithFolds" should {
    "check if a string is naughty or nice" in {
      val input1 = "ugknbfddgicrmopn"
      val input2 = "aaa"
      val input3 = "jchzalrnumimnmhp"
      val input4 = "haegwjzuvuyypxyu"
      val input5 = "dvszwmarrgswjxmb"

      isNiceStringWithFolds(input1) shouldBe true
      isNiceStringWithFolds(input2) shouldBe true
      isNiceStringWithFolds(input3) shouldBe false
      isNiceStringWithFolds(input4) shouldBe false
      isNiceStringWithFolds(input5) shouldBe false
    }
  }

  "isNiceStringPt2" should {
    "check if a string is naughty or nice" in {
      val input1 = "qjhvhtzxzqqjkmpb"
      val input2 = "xxyxx"
      val input3 = "uurcxstgmygtbstg"
      val input4 = "ieodomkazucvgmuy"

      isNiceStringPt2(input1) shouldBe true
      isNiceStringPt2(input2) shouldBe true
      isNiceStringPt2(input3) shouldBe false
      isNiceStringPt2(input4) shouldBe false
    }
  }
}
