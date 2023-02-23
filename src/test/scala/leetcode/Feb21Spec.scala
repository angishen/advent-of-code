package leetcode

import leetcode.Feb21.{addBinary, bitwiseComplement}
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Feb21Spec extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {
  "bitwiseComplement" should {
    "return the bitwise complement of an integer" in {
      val table = Table(
        ("input", "expected"),
        (5, 2),
        (7, 0),
        (10, 5),
        (0, 1)
      )

      forEvery(table) { (input, expected) =>
        bitwiseComplement(input) shouldBe expected
      }
    }
  }

  "addBinary" should {
    "add two binary strings" in {
      val table = Table(
        ("input", "expected"),
        (("11", "1"), "100"),
        (("1010", "1011"), "10101"),
      )

      forEvery(table) { (input, expected) =>
        val (a, b) = input
        addBinary(a, b) shouldBe expected
      }
    }
  }
}
