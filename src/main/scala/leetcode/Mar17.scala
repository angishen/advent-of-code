package leetcode

object Mar17 extends App {
  /*
  Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
  You must write an algorithm with O(log n) runtime complexity.
  */
  def searchInsert(nums: Array[Int], target: Int): Int = {
    def bsHelper(left: Int, right: Int): Int = {
      val mid = (left + right) / 2
      println(s"l: $left, r: $right, m: $mid")
      if (left >= right && left == nums.length - 1) left + 1
      else if (left >= right) left
      else if (nums(mid) == target) mid
      else if (nums(mid) > target) bsHelper(left, mid)
      else bsHelper(mid + 1, right)
    }

    val res = bsHelper(0, nums.length - 1)
    println("==========================")

    res
  }

}
