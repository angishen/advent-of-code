package leetcode

import leetcode.Feb15.{ListNode, binarySearch, containsDuplicate, mergeTwoListsRecursive, runningSum, runningSum2}
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Feb15Spec extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {
  "climbStairs" should {
    "return the unique number of ways to climb a staircasen" in {
//      val table = Table(
//        ("input", "expected"),
//        (2, 2),
//        (3, 3),
//      )
    }
  }

  "runningSum" should {
    "return a running sum of an array of numbers" in {
      val table = Table(
        ("input", "expected"),
        (Array(1,2,3,4), Array(1,3,6,10)),
        (Array(1,1,1,1,1), Array(1,2,3,4,5)),
        (Array(3,1,2,10,1), Array(3,4,6,16,17)),
      )

      forEvery(table) { (input, expected) =>
        runningSum(input) shouldBe expected
        runningSum2(input) shouldBe expected
      }
    }
  }

  "containsDuplicates" should {
    "return true if an array contains no duplicate values" in {
      val table = Table(
        ("input", "expected"),
        (Array(1,2,3,1), true),
        (Array(1,2,3,4), false),
        (Array(1,1,1,3,3,4,3,2,4,2), true),
      )

      forEvery(table) { (input, expected) =>
        containsDuplicate(input) shouldBe expected
      }
    }
  }

  "mergeTwoListsRecursive" should {
    "merge two sorted linked lists recursively" in {
      val table = Table(
        ("input", "expected"),
        (
          (
            new ListNode(1, new ListNode(2, new ListNode(4, null))),
            new ListNode(1, new ListNode(3, new ListNode(4, null)))
          ),
          new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, null))))))
        ),
        ((null, null), null),
        ((null, new ListNode(0, null)), new ListNode(0, null))
      )

      forEvery(table) { (input, expected) =>
        val (list1, list2) = input
        mergeTwoListsRecursive(list1, list2) shouldBe expected
      }
    }
  }

  "binarySearch" should {
    "binary search an array" in {
      val table = Table(
        ("input", "expected"),
        ((Array(-1,0,3,5,9,12), 9), 4),
        ((Array(-1,0,3,5,9,12), 2), -1),
        ((Array(5), 5), 0)
      )

      forEvery(table) { (input, expected) =>
        val (nums, target) = input
        binarySearch(nums, target) shouldBe expected
      }
    }
  }
}
