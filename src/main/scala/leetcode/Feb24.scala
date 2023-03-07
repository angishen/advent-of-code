package leetcode

import scala.collection.mutable

object Feb24 extends App {
  /*
  Design a logger system that receives a stream of messages along with their timestamps. Each unique message should only be printed at most every 10 seconds (i.e. a message printed at timestamp t will prevent other identical messages from being printed until timestamp t + 10).

  All messages will come in chronological order. Several messages may arrive at the same timestamp.
  */
  class Logger() {
    private val messageMap = mutable.Map[String, Int]()

    def shouldPrintMessage(timestamp: Int, message: String): Boolean = {
      messageMap.get(message) match {
        case Some(prevTimestamp) => timestamp - prevTimestamp >= 10
        case None =>
          messageMap(message) = timestamp + 10
          true
      }
    }
  }
}
