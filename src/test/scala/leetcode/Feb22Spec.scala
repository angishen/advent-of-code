package leetcode

import leetcode.Feb22.{isPowerOfTwo, isPowerOfTwo2, moveZeros}
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Feb22Spec extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {
  "moveZeros" should {
    "move all of the zeros in an array to the end" in {
      val table = Table(
        ("input", "expected"),
        (Array(0,1,0,3,12), Array(1,3,12,0,0)),
        (Array(0), Array(0)),
        (Array(1), Array(1)),
        (Array(1,0,1,0,1,0), Array(1,1,1,0,0,0))
      )

      forEvery(table) { (input, expected) =>
        moveZeros(input) shouldBe expected
      }
    }
  }

  "isPowerOfTwo" should {
    "return true if n is a power of 2" in {
      val table = Table(
        ("input", "expected"),
        (1, true),
        (16, true),
        (3, false),
        // this case would fail for the first function
        // (536870912, true)
      )

      forEvery(table) { (input, expected) =>
        isPowerOfTwo(input) shouldBe expected
        isPowerOfTwo2(input) shouldBe expected
      }
    }
  }
}
