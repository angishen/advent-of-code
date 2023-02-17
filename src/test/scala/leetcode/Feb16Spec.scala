package leetcode

import leetcode.Feb16.{pascalsTriangle, removeDuplicates}
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

  "pascalsTriangle" should {
    "generate n number of rows of pascal's triangle" in {
      val table = Table(
        ("input", "expected"),
        (5, List(List(1), List(1,1), List(1,2,1), List(1,3,3,1), List(1,4,6,4,1))),
        (1, List(List(1)))
      )

      forEvery(table) { (input, expected) =>
        pascalsTriangle(input) shouldBe expected
      }
    }
  }
}
