package leetcode

import scala.collection.mutable

object Mar07 extends App {
  /*
  Given a string s, reverse only all the vowels in the string and return it.
  The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
  */
  def reverseVowels(s: String): String = {
    val vowels = Set('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    val res = s.toArray

    var l = 0
    var r = res.length - 1

    while (l <= r) {
      if (vowels.contains(res(l)) && vowels.contains(res(r))) {
        val temp = res(l)
        res(l) = res(r)
        res(r) = temp
        l += 1
        r -= 1
      } else if (vowels.contains(res(l))) {
        r -= 1
      } else if (vowels.contains(res(r))) {
        l += 1
      } else {
        l += 1
        r -= 1
      }
    }

    res.mkString
  }
}
