package leetcode

import leetcode.Mar24.{addBinary, isHappy}
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Mar24Spec extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {
  "isHappy" should {
    "return whether a number is happy or sad" in {
      val table = Table(
        ("input", "expected"),
        (19, true),
        (2, false)
      )

      forEvery(table) { (input, expected) =>
        isHappy(input) shouldBe expected
      }
    }
  }
//   "addBinary" should {
//    "add two binary strings" in {
//      val table = Table(
//        ("input", "expected"),
//        (("11", "1"), "100"),
//        (("1010", "1011"), "10101"),
//      )
//
//      forEvery(table) { (input, expected) =>
//        val (a, b) = input
//        addBinary(a, b) shouldBe expected
//      }
//    }
//  }
}
