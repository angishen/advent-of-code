package leetcode

import leetcode.Feb28.{fib, merge}
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Feb28Spec extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {
//  "isHappy" should {
//    "return if a number is a happy number" in {
//      val table = Table(
//        ("input", "expected"),
//        (19, true),
//        (2, false),
//      )
//
//      forEvery(table) { (input, expected) =>
//        isHappy(input) shouldBe expected
//      }
//    }
//  }

  "fib" should {
    "return the fibonacci value of n" in {
      val table = Table(
        ("input", "expected"),
        (2, 1),
        (3, 2),
        (4, 3)
      )

      forEvery(table) { (input, expected) =>
        fib(input) shouldBe expected
      }
    }
  }

  "merge" should {
    "merge two sorted arrays in place" in {
      val table = Table(
        ("input", "expected"),
        ((Array(2,3,5,0,0,0), 3, Array(4,6,7), 3), Array(2,3,4,5,6,7)),
        ((Array(1,1,1,0,0,0), 3, Array(1,1,1), 3), Array(1,1,1,1,1,1)),
        ((Array(1,2,3,0,0,0), 3, Array(2,5,6), 3), Array(1,2,2,3,5,6)),
//        ((Array(1), 1, Array(), 0), Array(1)),
        ((Array(0), 0, Array(1), 1), Array(1)),
      )

      forEvery(table) { (input, expected) =>
        val (nums1, m, nums2, n) = input

        merge(nums1, m, nums2, n) shouldBe expected
      }
    }
  }
}
