package adventofcode2015.asides

import scala.collection.mutable

// Practicing topological sort in a leetcode problem
// Ugh doing this all mutably is very weird and gross
object TopologicalSort extends App {
  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
    val openCourses: mutable.Set[Int] = mutable.Set[Int]()
    val prereqToCourses: mutable.HashMap[Int, mutable.Set[Int]] = mutable.HashMap.empty
    var remainingPrereqCount: mutable.HashMap[Int, Int] = mutable.HashMap.empty
    var sortedList: Array[Int] = Array.empty

    for(i <- Range(0, numCourses, 1)) {
      // initialize openCourses set with all classes
      openCourses += i
      // initialize adjacency map with all classes
      prereqToCourses += i -> mutable.Set()
      // initialize dependency cont map with all classes
      remainingPrereqCount += i -> 0
    }

    for (Array(course, prereq) <- prerequisites) {
      // remove dependent courses
      openCourses -= course
      // build courseToPrereq map
      prereqToCourses(prereq) += course
      // build prereq count map
      remainingPrereqCount(course) += 1
    }

    // remove courses that don't have dependencies from remainingPrereqCount map
    remainingPrereqCount = remainingPrereqCount.filter {
      case (_, v) => v != 0
    }

    println("----------initial state---------")
    println(s"openCourses: $openCourses")
    println(s"prereqToCourses: $prereqToCourses")
    println(s"remainingPrereqCount: $remainingPrereqCount")

    // topological sort
    while (!openCourses.isEmpty) {
      val prereq = openCourses.head
      openCourses.remove(prereq)
      sortedList = sortedList :+ prereq

      println("----------in while loop---------")
      println(s"prereq: $prereq")
      println(s"prereqToCourses in while: $prereqToCourses")
      println(s"remainingPrereqCount: $remainingPrereqCount")

      for (course <- prereqToCourses(prereq)) {
        remainingPrereqCount(course) -= 1
        if (remainingPrereqCount(course) == 0) {
          openCourses += course
          remainingPrereqCount -= course
        }
      }
      prereqToCourses -= prereq
    }

    println("------------end state-----------")
    println(s"openCourses: $openCourses")
    println(s"prereqToCourses: $prereqToCourses")
    println(s"remainingPrereqCount: $remainingPrereqCount")
    println(sortedList.toList)

    remainingPrereqCount.isEmpty
  }

  println(canFinish(5, Array(Array(1,4), Array(2, 4), Array(3, 1), Array(3, 2))))
}
