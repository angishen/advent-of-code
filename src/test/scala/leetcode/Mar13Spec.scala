package leetcode

import leetcode.Mar13.{isAnagram, majorityElement, majorityElementO1Space, removeDuplicates}
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Mar13Spec extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {
  "isAnagram" should {
    "return true if two strings are anagrams of each other" in {
      val table = Table(
        ("input", "expected"),
        (("anagram", "nagaram"), true),
        (("rat", "car"), false),
        (("a", "a"), true),
        (("shenanigans", "angishensan"), true)
      )

      forEvery(table) { (input, expected) =>
        val (word1, word2) = input
        isAnagram(word1, word2) shouldBe expected
      }
    }
  }
  "majorityElement" should {
    "find the majority element in a list of numbers" in {
      val table = Table(
        ("input", "expected"),
        (Array(3,2,3), 3),
        (Array(2,2,1,1,1,2,2), 2),
        (Array(1,1,1,1,1,1), 1),
        (Array(1), 1)
      )

      forEvery(table) { (input, expected) =>
        majorityElement(input) shouldBe expected
        majorityElementO1Space(input) shouldBe expected
      }
    }
  }

  "removeDuplicates" should {
    "remove all adjacent duplicate letters in a string" in {
      val table = Table(
        ("input", "expected"),
        ("abbaca", "ca"),
        ("azxxzy", "ay")
      )

      forEvery(table) { (input, expected) =>
        removeDuplicates(input) shouldBe expected
      }
    }
  }
}
