package leetcode

import leetcode.Feb21.bitwiseComplement
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


}
