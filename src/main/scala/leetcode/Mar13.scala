package leetcode

import scala.collection.mutable

object Mar13 extends App {
  /*
   242. Given two strings s and t, return true if t is an anagram of s, and false otherwise.
  An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
  */
  def isAnagram(s: String, t: String): Boolean = {
   val letterMap = mutable.Map[Char, Int]()

    s.foreach { c =>
      letterMap.updateWith(c) {
        case Some(count) => Some(count + 1)
        case None => Some(1)
      }
    }

    t.foreach { c =>
      letterMap.updateWith(c) {
        case Some(count) => Some(count - 1)
        case None => Some(1)
      }
    }

    val charDiffSet = letterMap.values.toList.toSet

    charDiffSet.size == 1 && charDiffSet.head == 0
  }

  /*
  169. Given an array nums of size n, return the majority element.
  The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
  */
  def majorityElement(nums: Array[Int]): Int = {
    val frequencyMap = mutable.Map[Int, Int]()

    nums.foreach { n =>
      frequencyMap.updateWith(n) {
        case Some(n) => Some(n + 1)
        case None => Some(1)
      }
    }

    frequencyMap.maxBy(_._2)._1
  }

  // Boyer-Moore voting algorithm
  def majorityElementO1Space(nums: Array[Int]): Int = {
    var count = 0
    var candidate = 0

    nums.foreach { n =>
      if (count == 0) candidate = n
      count = if (n == candidate) count + 1 else count - 1
    }

    candidate
  }
}
