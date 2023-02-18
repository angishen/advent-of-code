package leetcode

import leetcode.Feb17.{firstUniqChar, pascalsTriangle, sortByBits}
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Feb17Spec extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {
  "pascalsTriangle" should {
    "build pascals triangle given a number of rows" in {
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

  "firstUniqChar" should {
    "return the index of the first unique character otherwise -1" in {
      val table = Table(
        ("input", "expected"),
        ("leetcode", 0),
        ("loveleetcode", 2),
        ("aabb", -1),
        ("a", 0),
      )

      forEvery(table) { (input, expected) =>
        firstUniqChar(input) shouldBe expected
      }
    }
  }

  "sortByBits" should {
    "sort any array of ints by their binary string length" in {
      val table = Table(
        ("input", "expected"),
        (Array(0,1,2,3,4,5,6,7,8), Array(0,1,2,4,8,3,5,6,7)),
        (Array(1024,512,256,128,64,32,16,8,4,2,1), Array(1,2,4,8,16,32,64,128,256,512,1024)),
        (Array(0), Array(0))
      )

      forEvery(table) { (input, expected) =>
        sortByBits(input) shouldBe expected
      }
    }
  }
}
