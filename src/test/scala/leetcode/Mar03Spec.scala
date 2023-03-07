package leetcode

import leetcode.Mar03.{checkAlmostEquivalent, maximum69Number}
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Mar03Spec extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {
  "checkAlmostEquivalent" should {
    "check if two words are almost equivalent" in {
      val table = Table(
        ("input", "expected"),
        (("aaaa", "bccb"), false),
        (("abcdeef", "abaaacc"), true),
        (("cccddabba", "babababab"), true),
      )

      forEvery(table) { (input, expected) =>
        val (word1, word2) = input

        checkAlmostEquivalent(word1, word2) shouldBe expected
      }
    }
  }

  "max69Number" should {
    "return the largest number by flipping one digit" in {
      val table = Table(
        ("input", "expected"),
        (9669, 9969)
      )

      forEvery(table) { (input, expected) =>
        maximum69Number(input) shouldBe expected
      }
    }
  }
}
