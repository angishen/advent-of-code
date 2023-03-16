package leetcode

import scala.collection.mutable

object Mar14 extends App {
  /*
  You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
  We repeatedly make duplicate removals on s until we no longer can.
  Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
  */

  def removeDuplicates(s: String): String = {
    val stack = mutable.ArrayDeque[Char]()

    s.foreach { c =>
      if (!stack.isEmpty && stack.last == c) {
        stack.removeLast()
      } else {
        stack.append(c)
      }
    }

    stack.mkString
  }
}
