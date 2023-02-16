package leetcode

import scala.collection.mutable.ArrayDeque
import scala.collection.mutable

object Feb13 extends App {

  /*
   Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
   */

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val numToIdx = mutable.Map[Int, Int]()
    val result = ArrayDeque[Int]()

    for ((num, idx) <- nums.zipWithIndex) {
      val complement = target - num
      if (numToIdx.get(complement).nonEmpty) {
        result ++= ArrayDeque(idx, numToIdx(complement))
      } else {
        numToIdx(num) = idx
      }
    }
    result.toArray
  }

  /*
  Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

  An input string is valid if:
  - Open brackets must be closed by the same type of brackets.
  - Open brackets must be closed in the correct order.
  - Every close bracket has a corresponding open bracket of the same type.
  */

  def isValidParens(s: String): Boolean = {
    val parensMap = Map(
      '(' -> ')',
      '{' -> '}',
      '[' -> ']'
    )

    val stack = ArrayDeque[Char]()

    for (c <- s) {
      if (parensMap.contains(c)) {
        stack.append(c)
      } else {
        if (stack.isEmpty) {
          return false
        }
        val complement = stack.removeLast()
        if (parensMap(complement) != c) {
          return false
        }
      }
    }

    stack.isEmpty
  }

  /*
  Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
  */

  def uniqueOccurrences(arr: Array[Int]): Boolean = {
    val numToOccurrences = collection.mutable.Map[Int, Int]()

    for (num <- arr) {
      numToOccurrences.updateWith(num) {
        case Some(count) => Some(count + 1)
        case None => Some(1)
      }
    }

    numToOccurrences.values.toList.length == numToOccurrences.values.toSet.size
  }

  /*
  You are given an array prices where prices[i] is the price of a given stock on the ith day.

  You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

  Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
  */

  def maxProfitStock(prices: Array[Int]): Int = {
    var maxProfit = Double.NegativeInfinity
    var minPriceSeen = Double.PositiveInfinity

    for (price <- prices) {
      minPriceSeen = Math.min(price, minPriceSeen)
      val profitIfSellToday = price - minPriceSeen
      maxProfit = Math.max(profitIfSellToday, maxProfit)
    }

    maxProfit.toInt
  }

  /*
  Write a function to find the longest common prefix string amongst an array of strings.

  If there is no common prefix, return an empty string "".
  */

  class Trie {
    class Node(val children: mutable.Map[Char, Node] = mutable.Map())

    val root = new Node()

    def add(s: String): Unit = {
      var current = root
      for (c <- s) {
        current = current.children.getOrElseUpdate(c, new Node())
      }
    }

    def findLongestPrefix(): String = {
      var current = root

      val prefix = ArrayDeque[Char]()

      while (current.children.size == 1) {
        val c = current.children.keys.toList.head
        prefix.append(c)
        current = current.children(c)
      }

      prefix.mkString
    }
  }

  def longestCommonPrefix(strs: Array[String]): String = {
    val myTrie = new Trie()

    // build trie
    strs.foreach(myTrie.add(_))

    // find longest prefix
    val longestPrefix = myTrie.findLongestPrefix()

    // address edge case where prefix is longer than shortest string in list
    val shortestStr = strs.minBy(_.length)

    if (longestPrefix.length > shortestStr.length) shortestStr else longestPrefix
  }
}
