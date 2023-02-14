package leetcode

import leetcode.Feb13.{isValidParens, longestCommonPrefix, maxProfitStock, twoSum, uniqueOccurrences}
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Feb13Spec extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {
  "twoSum" should {
    "return the indices of two numbers that add up the the target value" in {
      val table = Table(
        ("input", "expected"),
        ((Array(2, 7, 11, 15), 9), Array(0, 1)),
        ((Array(3, 2, 4), 6), Array(1, 2)),
        ((Array(3, 3), 6), Array(0, 1)),
      )

      forEvery(table) { (input, expected) =>
        val (nums, target) = input
        twoSum(nums, target).sorted shouldBe expected
      }
    }
  }

  "isValidParens" should {
    "check if a string of parenthesis is well formed" in {
      val table = Table(
        ("input", "expected"),
        ("()", true),
        ("()[]{}", true),
        ("(]", false),
        ("()()(){}{}[]]", false),
        ("((((((([[])))", false),
        ("((([[[]]]))){}{}{}", true)
      )

      forEvery(table) { (input, expected) =>
        isValidParens(input) shouldBe expected
      }
    }
  }

  "uniqueOccurrences" should {
    "return true if no value in the input occurs the same number of times" in {
      val table = Table(
        ("input", "expected"),
        (Array(1,2,2,1,1,3), true),
        (Array(1,2), false),
        (Array(-3,0,1,-3,1,1,1,-3,10,0), true),
      )

      forEvery(table) { (input, expected) =>
        uniqueOccurrences(input) shouldBe expected
      }
    }
  }

  "maxProfitStock" should {
    "return the max profit from buying and selling a stock" in {
      val table = Table(
        ("input", "expected"),
        (Array(7,1,5,3,6,4), 5),
        (Array(7,6,4,3,1), 0),
      )

      forEvery(table) { (input, expected) =>
        maxProfitStock(input) shouldBe expected
      }
    }
  }

  "longestCommonPrefix" should {
    "find the longest common prefix string given an array of strings" in {
      val table = Table(
        ("input", "expected"),
        (Array("flower", "flow","flight"), "fl"),
        (Array("dog", "racecar","car"), ""),
        (Array("b", "beach"), "b"),
        (Array("", "apple", "appalachia"), ""),
        (Array("hello", "hellebore", "hell's kitchen"), "hell")
      )

      forEvery(table) { (input, expected) =>
        longestCommonPrefix(input) shouldBe expected
      }
    }
  }
}
