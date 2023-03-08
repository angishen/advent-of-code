package leetcode

import leetcode.Mar07.reverseVowels
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Mar07Spec extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {
  "reverseVowels" should {
    "reverse the vowels in a word" in {
      val table = Table(
        ("input", "expected"),
        ("hello", "holle"),
        ("leetcode", "leotcede"),
        ("whatupimangi", "whitapimunga"),
        ("", ""),
        ("gkfkdkdd", "gkfkdkdd"),
        ("aeiou", "uoiea"),
        ("abebibobu", "ubobibeba"),
        ("Aa", "aA")
      )

      forEvery(table) { (input, expected) =>
        reverseVowels(input) shouldBe expected
      }
    }
  }
}
