package leetcode

import leetcode.Mar17.searchInsert
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Mar17Spec extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {
  "searchInsert" should {
    "return the index where target is found or should be inserted" in {
      val table = Table(
        ("input", "expected"),
        ((Array(1,3,5,6), 5), 2),
        ((Array(1,3,5,6), 2), 1),
        ((Array(1,3,5,6), 7), 4),
        ((Array(1,2,3,4), 0), 0),
        ((Array(1,2,3,4,6), 5), 4),
      )

      forEvery(table) { (input, expected) =>
        val (nums, target) = input

        searchInsert(nums, target) shouldBe expected
      }
    }
  }
}
