package leetcode

import leetcode.Feb14.{ListNode, isPalindromeLL, isPalindromeLLHard, isPalindromeNum}
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Feb14Spec extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {
  "isPalindromeNum" should {
    "return true if a number is a palindrome, otherwise false" in {
      val table = Table(
        ("input", "expected"),
        (121, true),
        (-121, false),
        (10, false),
        (1221, true),
        (1, true)
      )

      forEvery(table) { (input, expected) =>
        isPalindromeNum(input) shouldBe expected
      }
    }
  }

  "isPalindromeLL" should {
    "return true if a number represented by a linked list is a palindrome, otherwise false" in {
      val table = Table(
        ("input", "expected"),
        (new ListNode(1, new ListNode(2, new ListNode(1, null))), true),
        (new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1, null)))), true),
        (new ListNode(1, new ListNode(2, null)), false),
        (new ListNode(1, null), true)
      )

      forEvery(table) { (input, expected) =>
        isPalindromeLL(input) shouldBe expected
      }
    }
  }
}
