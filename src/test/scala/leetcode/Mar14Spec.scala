package leetcode

import leetcode.Mar14.removeDuplicates
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Mar14Spec extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {
  "removeDuplicates" should {
    "remove all adjacent duplicate letters in a string" in {
      val table = Table(
        ("input", "expected"),
        ("abbaca", "ca"),
        ("azxxzy", "ay")
      )

      forEvery(table) { (input, expected) =>
        removeDuplicates(input) shouldBe expected
      }
    }
  }
}
