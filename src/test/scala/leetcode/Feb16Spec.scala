package leetcode

import leetcode.Feb16.removeDuplicates
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Feb16Spec extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {
  "removeDuplicates" should {
    "remove duplicate values from an array in place" in {
      val table = Table(
        ("input", "expected"),
        (Array(1,1,2), 2),
        (Array(0,0,1,1,1,2,2,3,3,4), 5),
        (Array(0), 1),
        (Array(1,1), 1),
        (Array(1,1,1,1,1,1,1,1,1,1,1), 1)
      )

      forEvery(table) { (input, expected) =>
        removeDuplicates(input) shouldBe expected
      }
    }
  }
}
