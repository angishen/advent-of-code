package leetcode

import scala.collection.mutable

object Mar03 extends App {
  /*
  2068. Two strings word1 and word2 are considered almost equivalent if the differences between the frequencies of each letter from 'a' to 'z' between word1 and word2 is at most 3.

  Given two strings word1 and word2, each of length n, return true if word1 and word2 are almost equivalent, or false otherwise.

  The frequency of a letter x is the number of times it occurs in the string.
  */
  def checkAlmostEquivalent(word1: String, word2: String): Boolean = {
    val frequencyMap = mutable.Map[Char, (Int, Int)]()

    word1.foreach { c =>
      frequencyMap.updateWith(c) {
        case Some((count1, count2)) => Some((count1 + 1, count2))
        case None => Some((1, 0))
      }
    }

    word2.foreach { c =>
      frequencyMap.updateWith(c) {
        case Some((count1, count2)) => Some((count1, count2 + 1))
        case None => Some((0, 1))
      }
    }

    frequencyMap.values.map { case (count1, count2) =>
      Math.abs(count1 - count2)
    }.toList.max <= 3
  }

  /*
  You are given a positive integer num consisting only of digits 6 and 9.

  Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
  */
  // Yeah definitely don't wanna fuck around with string -> int conversions in scala b/c weird shit happens?
  // Let's stick to a mathy solution
  def maximum69Number(num: Int): Int = {
    if (num / 1000 == 6) num + 3000
    else if ((num % 1000) / 100 == 6) num + 300
    else if ((num % 100) / 10 == 6) num + 30
    else if ((num % 10) / 1 == 6) num + 3
    else num
  }
}
