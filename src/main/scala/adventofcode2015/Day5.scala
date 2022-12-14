package adventofcode2015

import adventofcode2015.utils.Timer.time

import scala.annotation.tailrec
import scala.io.Source

/**
 * Santa needs help figuring out which strings in his text file are naughty or nice.
 *
 * A nice string is one with all of the following properties:
 *
 * It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
 * It contains at least one letter that appears twice in a row, like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
 * It does not contain the strings ab, cd, pq, or xy, even if they are part of one of the other requirements.
 *
 * Realizing the error of his ways, Santa has switched to a better model of determining whether a string is naughty or nice. None of the old rules apply, as they are all clearly ridiculous.

 * Now, a nice string is one with all of the following properties:

 * It contains a pair of any two letters that appears at least twice in the string without overlapping, like xyxy (xy) or aabcdefgaa (aa), but not like aaa (aa, but it overlaps).
 * It contains at least one letter which repeats with exactly one letter between them, like xyx, abcdefeghi (efe), or even aaa.
 **/

object Day5 extends App {

  def isNiceString(input: String): Boolean = {
    val vowels = Set('a', 'e', 'i', 'o', 'u')
    val forbiddenStrings = Set("ab", "cd", "pq", "xy")
    var doubleLetter = false
    var vowelCount = 0
    var index = 0

    while (index < input.length - 1) {
      val substr = input.slice(index, index + 2)
      val char1 = substr(0)
      val char2 = substr(1)

      if (forbiddenStrings.contains(substr)) {
        return false
      }

      if (vowels.contains(char1)) vowelCount += 1
      doubleLetter ||= char1 == char2

      index += 1
    }

    if (vowels.contains(input.last)) vowelCount += 1

    vowelCount > 2 && doubleLetter
  }

  def isNiceStringTailRec(input: String): Boolean = {
    val vowels = Set('a', 'e', 'i', 'o', 'u')
    val forbiddenStrings = Set("ab", "cd", "pq", "xy")

    @tailrec
    def loop(vowelCount: Int, doubleLetter: Boolean, index: Int): Boolean = {
      if (index > input.length - 2) {
        return vowelCount > 2 && doubleLetter
      }

      val substr = input.slice(index, index + 2)
      val char1 = substr(0)
      val char2 = substr(1)

      if (forbiddenStrings.contains(substr)) return false

      if (vowels.contains(char1)) {
        loop(vowelCount + 1, doubleLetter || char1 == char2, index + 1)
      } else {
        loop(vowelCount, doubleLetter || char1 == char2, index + 1)
      }
    }

    val initVowelCount = if (vowels.contains(input.last)) 1 else 0


    loop(initVowelCount, false, 0)
  }

  def isNiceStringWithFolds(input: String): Boolean = {
    val vowels = Set('a', 'e', 'i', 'o', 'u')
    val forbiddenStrings = Set("ab", "cd", "pq", "xy")

    val substrs2 = input.sliding(2, 1).toSeq

    val hasForbiddenStrs = substrs2.foldLeft(false)((isForbidden, ss) => isForbidden || forbiddenStrings.contains(ss))
    val hasDoubleLetter = substrs2.foldLeft(false)((hasDoubleLtr, ss) => hasDoubleLtr || ss(0) == ss(1))
    val vowelCount = input.foldLeft(0)((count, c) => if (vowels.contains(c)) count + 1 else count)

    !hasForbiddenStrs && hasDoubleLetter && vowelCount > 2
  }

  def isNiceString3(input: String): Boolean = {
    val vowels = Set('a', 'e', 'i', 'o', 'u')
    val forbiddenStrings = Set("ab", "cd", "pq", "xy")

    val containsForbiddenStrings = forbiddenStrings.map(input.contains(_)).reduce(_ || _)
    val containsDoubleLetter = input.toList.distinct.size != input.length
    val vowelCountGreaterThan2 = vowels.map(input.contains(_)).count(_ == true) > 2

    (containsForbiddenStrings || vowelCountGreaterThan2) && containsDoubleLetter
  }

  def isNiceStringPt2(input: String): Boolean = {
    val strPairRegex = raw"([a-z]{2}).*\1".r
    val repeatStrRegex = raw"([a-z])[a-z]\1".r

    // The following would work if the middle letter had to be different from the two repeating letters
    // val repeatStrRegex = raw"([a-z])(?!\1)[a-z]\1".r

    strPairRegex.unanchored.matches(input) && repeatStrRegex.unanchored.matches(input)
  }

  private def readFromfile(fileName: String): List[String] = Source.fromResource(fileName).getLines.toList

  def niceStrCount(input: List[String])(isNiceStringFn: String => Boolean): Int =
    input.foldLeft(0)((niceStrCount, str) => if (isNiceStringFn(str)) niceStrCount + 1 else niceStrCount)

  val input = readFromfile("day5Input.txt")

  println(niceStrCount(input)(isNiceStringPt2))

//  println(time { niceStrCount(input)(isNiceString) })
//  println(time { niceStrCount(input)(isNiceStringTailRec) })
//  println(time { niceStrCount(input)(isNiceString) })
//  println(time { niceStrCount(input)(isNiceStringTailRec) })
//  println(time { niceStrCount(input)(isNiceStringWithFolds) })
//  println(time { niceStrCount(input)(isNiceString3) })

}
