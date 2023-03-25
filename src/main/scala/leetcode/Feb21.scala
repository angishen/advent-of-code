package leetcode

import scala.collection.mutable

object Feb21 extends App {
  /*
  1009. Complement of Base 10 Integer

  The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
  For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
  Given an integer n, return its complement.
  */
  def bitwiseComplement(n: Int): Int = {
    // How does this work?
    // The bit mask places a 1 in every used bit of n. When XORd with n, this flips all of the bits of n.
    // Integer.highestOneBit gets the highest used bit of n. << shifts the highest bit left by one. Subtracting
    // the value by 1 sets all of the used bits of n to 1s.
    val mask = (Integer.highestOneBit(n) << 1) - 1
    // Integer.highestOnBit returns 0 if n is 0 which would cause the mask to be all 0s
    if (n == 0) 1 else n ^ mask
  }
}




