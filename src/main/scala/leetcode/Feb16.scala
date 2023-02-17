package leetcode

object Feb16 extends App {
  /*
  Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
  Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
  Return k after placing the final result in the first k slots of nums.
  Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
  */
  def removeDuplicates(nums: Array[Int]): Int = {
    // 2 pointers 1 @ sorted boundary, 1 @ idx
    var sortedBoundary = 1
    var idx = 1
    var currVal = nums(0)

    while (idx < nums.length) {
      if (nums(idx) == currVal) {
        idx += 1
      } else {
        currVal = nums(idx)
        val temp = nums(sortedBoundary)
        nums(sortedBoundary) = nums(idx)
        nums(idx) = temp
        idx += 1
        sortedBoundary += 1
      }
    }

    sortedBoundary
  }

  /*
    Given an integer numRows, return the first numRows of Pascal's triangle.
  */
  def pascalsTriangle(numRows: Int): List[List[Int]] = {
    def ptHelper(row: List[Int]): List[List[Int]] = {

    }
  }
}
