package leetcode

import scala.collection.mutable

object Feb28 extends App {
  /*
  Write an algorithm to determine if a number n is happy.

  A happy number is a number defined by the following process:

  Starting with any positive integer, replace the number by the sum of the squares of its digits.
  Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
  Those numbers for which this process ends in 1 are happy.
  Return true if n is a happy number, and false if not.
  */

//  def isHappy(n: Int): Boolean = {
//    def loop(n: Int): Int = {
//      if (n == 1) 1
//      else {
//        val sum = n.toString.toList.map(_.toInt).sum
//        loop(sum)
//      }
//    }
//  }

  def fib(n: Int): Int = {
    val memo = mutable.Map[Int, Int]()
    def recur(n: Int): Int = {
      if (memo.get(n).nonEmpty) memo(n)
      else if (n == 0) 0
      else if (n == 1) 1
      else {
        val res = recur(n - 1) + recur(n -2)
        memo(n) = res
        res
      }
    }

    recur(n)
  }

  /*
  You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

  Merge nums1 and nums2 into a single array sorted in non-decreasing order.

  The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
  */
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Array[Int] = {
    var idxMN = m + n - 1
    var idxM = m - 1
    var idxN = n - 1

    while (nums1(idxMN) == 0 && idxN >= 0 && idxM >= 0) {
      val temp = nums1(idxMN)
      if (nums1(idxM) > nums2(idxN)) {
        println(s"IF temp: $temp, idxMN: $idxMN, idxM: $idxM, idxN: $idxN")
        nums1(idxMN) = nums1(idxM)
        nums1(idxM) = temp
        println(nums1.mkString(", "))
        idxM -= 1
      } else {
        println(s"ELSE temp: $temp, idxMN: $idxMN, idxM: $idxM, idxN: $idxN")
        nums1(idxMN) = nums2(idxN)
        nums2(idxN) = temp
        println(nums1.mkString(", "))
        idxN -= 1
      }
      idxMN -= 1
    }

    nums1
  }
}
