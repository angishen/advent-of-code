package leetcode

import leetcode.Mar06.gcdOfStrings
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Mar06Spec extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {
  "gcdOfStrings" should {
    "return the greatest common denominator of two strings" in {
      val table = Table(
        ("input", "expected"),
        (("ABCABC", "ABC"), "ABC"),
        (("ABABAB", "ABAB"), "AB"),
        (("LEET", "CODE"), ""),
        (("AAAAAAAA", "AAAA"), "AAAA"),
      )

      forEvery(table) { (input, expected) =>
        val (str1, str2) = input

        gcdOfStrings(str1, str2) shouldBe expected
      }
    }
  }
}
