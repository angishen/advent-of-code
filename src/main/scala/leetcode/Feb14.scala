package leetcode

import scala.collection.mutable

object Feb14 extends App {

  /*
  Given an integer x, return true if x is a palindrome and false otherwise.
  */

  def isPalindromeNum(x: Int): Boolean = {
    val numAsStr = x.toString
    var start = 0
    var end = numAsStr.length - 1

    while (start < end) {
      if (numAsStr(start) != numAsStr(end)) return false
      start += 1
      end -= 1
    }

    true
  }

  /*
  Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
  */
  class ListNode(var value: Int = 0, var next: ListNode = null)

  def isPalindromeLL(head: ListNode): Boolean = {
    val arr = mutable.ArrayDeque[Int]()

    var current = head

    while (current != null) {
      arr.append(current.value)
      current = current.next
    }

    var start = 0
    var end = arr.length - 1

    while (start < end) {
      if (arr(start) != arr(end)) return false
      start += 1
      end -= 1
    }

    true
  }

  // TODO: come back to this one
  def isPalindromeLLHard(head: ListNode) = {

    var current = head
    // initiate pointer to find midpoint
    var mid = head

    // iterate through list to find midpoint
    while (current != null && current.next != null) {
      // current pointer progresses at 2x
      current = current.next.next
      // mid pointer progresses at 1x
      mid = mid.next
    }

    // reverse list from mid point
    var tempMid = mid
  }


}
