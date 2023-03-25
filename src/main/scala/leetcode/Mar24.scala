package leetcode

import scala.collection.mutable

object Mar24 extends App {
  /*
  202. Happy Number
  Write an algorithm to determine if a number n is happy.

  A happy number is a number defined by the following process:

  Starting with any positive integer, replace the number by the sum of the squares of its digits.
  Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
  Those numbers for which this process ends in 1 are happy.
  Return true if n is a happy number, and false if not.

  // Q: But when do you know to stop if it infinitely loops??
  // A: There's probably some mathy trick to this? Something about detecting cycles?

  */
  def isHappy(n: Int): Boolean = {
    val numsSeen = mutable.Set[Int]()

    def sumOfSquaredDigits(num: Int): Int = {
      var sum = 0
      var n = num

      while (n > 0) {
        val digit = n % 10
        n = n / 10
        sum += digit * digit
      }
      sum
    }

    def loop(n: Int): Boolean = {
      val nextNum = sumOfSquaredDigits(n)
      if (n == 1) true
      else if (numsSeen.contains(nextNum)) false
      else {
        numsSeen += nextNum
        loop(nextNum)
      }
    }
    loop(n)
  }

  /*
  67. Add Binary

  Given two binary strings a and b, return their sum as a binary string.

  Ugh this one probably has a bitwise mathy trick solution
  */
  def addBinary(a: String, b: String): String = ???
}
