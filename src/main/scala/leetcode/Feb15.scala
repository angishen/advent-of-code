package leetcode

import scala.collection.mutable

object Feb15 extends App {
  /*
  You are climbing a staircase. It takes n steps to reach the top.
  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
   */
  def climbStairs(n: Int): Int = ???

  /*
  Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
  Return the running sum of nums.
  */
  def runningSum(nums: Array[Int]): Array[Int] = {
    val res = mutable.ArrayDeque[Int]()

    // Seems ick to be mutating state from inside a fold but idk it works ¯\_(ツ)_/¯
    nums.foldLeft(0)((acc, num) => {
      res.append(acc + num)
      acc + num
    })

    res.toArray
  }

  def runningSum2(nums: Array[Int]): Array[Int] = {
    for (i <- Range(1, nums.length)) {
      nums(i) = nums(i) + nums(i-1)
    }

    nums
  }

  /*
  Given an integer array nums, return true if any value appears at least twice in the array,
  and return false if every element is distinct.
  */
  def containsDuplicate(nums: Array[Int]): Boolean = {
    val freqTable = mutable.Map[Int, Int]()

    for (num <- nums) {
      freqTable.updateWith(num) {
        case Some(num) => Some(num + 1)
        case None => Some(1)
      }
    }

    freqTable.values.size != nums.length
  }

  /*
  You are given the heads of two sorted linked lists list1 and list2.
  Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
  Return the head of the merged linked list.
  */
  class ListNode(var head: Int, var tail: ListNode)

  def mergeTwoListsRecursive(list1: ListNode, list2: ListNode): ListNode = {
    if (list1 == null) list2
    else if (list2 == null) list1
    else if (list1.head < list2.head) {
      list1.tail = mergeTwoListsRecursive(list1.tail, list2)
      list1
    }
    else {
      list2.tail = mergeTwoListsRecursive(list1, list2.tail)
      list2
    }
  }

  /*
  Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
  You must write an algorithm with O(log n) runtime complexity.
  */
  def binarySearch(nums: Array[Int], target: Int): Int = {
    def bsHelper(left: Int, right: Int): Int = {
      val mid = (right + left) / 2
      if (nums(mid) == target) mid
      else if (left >= right) -1
      else if (target > nums(mid)) bsHelper(mid + 1, right)
      else bsHelper(left, mid)
    }

    bsHelper(0, nums.length - 1)
  }
}
