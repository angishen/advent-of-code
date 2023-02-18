package leetcode

import scala.collection.mutable

object Feb17 extends App {
  /*
    Given an integer numRows, return the first numRows of Pascal's triangle.
  */
  def pascalsTriangle(numRows: Int): List[List[Int]] = {
    val memoize = mutable.Map[(Int, Int), Int]()

    def ptHelper(i: Int, j: Int): Int = {
      if (memoize.get((i, j)).nonEmpty) memoize((i, j))
      else if (j < 0 || i < 0) 0
      else if (j > i) 0
      else if (i == 0 && j == 0) 1
      else {
        val output = ptHelper(i-1, j-1) + ptHelper(i-1, j)
        memoize((i, j)) = output
        output
      }
    }

    val res = for {
      row <- Range(0, numRows)
      triangleRow = for {
        col <- Range(0, row + 1)
      } yield ptHelper(row, col)
    } yield triangleRow.toList

    res.toList
  }

  /*
  Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1
  */
  def firstUniqChar(s: String): Int = {
    val occurrences = mutable.Map[Char, Int]()

    s.foreach { c =>
      occurrences.updateWith(c) {
        case Some(count) => Some(count + 1)
        case None => Some(1)
      }
    }

    for ((c, i) <- s.zipWithIndex) {
      if (occurrences(c) == 1) return i
    }

    -1
  }

  /*
  You are given an integer array arr. Sort the integers in the array in ascending order by the number of 1's in their
  binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.
  Return the array after sorting it.
  */
  def sortByBits(arr: Array[Int]): Array[Int] = {
    arr.sortBy(num => (Integer.bitCount(num), num))
  }
}
