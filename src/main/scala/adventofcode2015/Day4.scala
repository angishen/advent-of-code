package adventofcode2015

import java.security.MessageDigest
import scala.annotation.tailrec

object Day4 extends App {
  def md5Hash(text: String): String =
    MessageDigest
      .getInstance("MD5")
      .digest(text.getBytes())
      .map("%02x".format(_))
      .foldLeft("")(_ + _)

  def getResultForKey(key: String): Int = {
    @tailrec
    def loop(num: Int): Int = {
      val hashInput = key + num.toString
      val hashOutput = md5Hash(hashInput)
      if (hashOutput.substring(0, 5) == "000000") {
        num
      } else {
        loop(num + 1)
      }
    }
    loop(1)
  }

  val input = "bgvyzdsv"
  println(getResultForKey(input))
}
