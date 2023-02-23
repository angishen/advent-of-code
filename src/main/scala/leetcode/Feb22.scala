package leetcode

object Feb22 extends App {
  def moveZeros(nums: Array[Int]): Array[Int] = {
    var zeroBoundary = 0

    for ((n, i) <- nums.zipWithIndex) {
      if (n != 0) {
        val temp = nums(zeroBoundary)
        nums(zeroBoundary) = n
        nums(i) = temp
        zeroBoundary += 1
      }
    }

    nums
  }

  def isPowerOfTwo(n: Int): Boolean = {
    // Change of base formula can convert log(e) -> log2
    // Note: there are floating point precision errors for some cases
    (Math.log(n) / Math.log(2)) % 1 == 0
  }

  def isPowerOfTwo2(n: Int): Boolean = {
    // This works because if n is a power of 2 in binary it will be 100...
    // and n-1 will be 011... so when you AND them, it will be 0
    n > 0 && (n & (n-1)) == 0
  }
}
