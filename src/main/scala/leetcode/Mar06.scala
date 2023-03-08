package leetcode

object Mar06 extends App {
  /*
  1071. For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
  Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
  */

  // Hell yeahhhhh proud of this clever, clean mathy solution
  def gcdOfStrings(str1: String, str2: String): String = {
    def calculateGCD(a: Int, b: Int): Int = {
      if (b == 0) a
      else calculateGCD(b, a % b)
    }

    val a = str1.length
    val b = str2.length
    val gcd = if (a > b) calculateGCD(a, b) else calculateGCD(b, a)

    val substr = (str1 + str2).grouped(gcd).toList.toSet

    if (substr.size == 1) substr.head else ""
  }
}
