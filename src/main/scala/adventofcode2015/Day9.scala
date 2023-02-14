package adventofcode2015

import scala.io.Source
import collection.mutable.Map

object Day9 extends App {
  """
    |Every year, Santa manages to deliver all of his presents in a single night.
    |
    |This year, however, he has some new locations to visit; his elves have provided him the distances between every pair of locations. He can start and end at any two (different) locations he wants, but he must visit each location exactly once. What is the shortest distance he can travel to achieve this?
    |
    |For example, given the following distances:
    |
    |London to Dublin = 464
    |London to Belfast = 518
    |Dublin to Belfast = 141
    |The possible routes are therefore:
    |
    |Dublin -> London -> Belfast = 982
    |London -> Dublin -> Belfast = 605
    |London -> Belfast -> Dublin = 659
    |Dublin -> Belfast -> London = 659
    |Belfast -> Dublin -> London = 605
    |Belfast -> London -> Dublin = 982
    |The shortest of these is London -> Dublin -> Belfast = 605, and so the answer is 605 in this example.
    |
    |What is the distance of the shortest route?
    |
    |
    |""".stripMargin

  // Floyd-Warshall Algorithm - like Djikstra's but finds the shortest path in a directed, weighted graph visiting all nodes

  case class TripLeg(start: String, dest: String, distance: Int)

  private def parseLine(input: String): List[TripLeg] = input.split("\\s(to|=)\\s").toList match {
    case start :: dest :: distance :: Nil => List(TripLeg(start, dest, distance.toInt), TripLeg(dest, start, distance.toInt))
  }

  // parse input into case classes
  private def readFromFile(fileName: String): List[TripLeg] = Source.fromResource(fileName).getLines().map(parseLine).toList.flatten

  // build graph from case classes
  private def buildGraph(legs: List[TripLeg]): Map[String, Map[String, Int]] = {
    val graph = Map[String, Map[String, Int]]()

    for (leg <- legs) {
      if (graph.get(leg.start).nonEmpty) {
        graph(leg.start) += leg.dest -> leg.distance
      } else {
        graph += leg.start -> Map(leg.dest -> leg.distance)
      }
    }

    graph
  }

  private def initializeMatrix(graph: Map[String, Map[String, Int]]): Array[Array[Double]] = {
    val vertices = graph.keys.toArray
    val size = vertices.length
    val matrix = Array.fill(size)(Array.fill(size)(Double.PositiveInfinity))

    for ((row, i) <- matrix.zipWithIndex) {
      for ((_, j) <- row.zipWithIndex) {
        if (i == j) matrix(i)(j) = 0
        else {
          val start = vertices(i)
          val dest = vertices(j)
          if (graph(start).get(dest).nonEmpty) {
            matrix(i)(j) = graph(start)(dest)
          }
        }
      }
    }

    matrix
  }

  // run Floyd-Warshall algorithm
  def shortestPath(matrix: Array[Array[Double]]): Array[Array[Double]] = {
    for ((_, k) <- matrix.zipWithIndex) {
      for ((_, i) <- matrix.zipWithIndex) {
        for ((_, j) <- matrix.zipWithIndex) {
          if (matrix(i)(j) > matrix(i)(k) + matrix(k)(j)) {
            matrix(i)(j) = matrix(i)(k) + matrix(k)(j)
          }
        }
      }
    }
    matrix
  }

//  val input =
//      """
//      |London to Dublin = 464
//      |London to Belfast = 518
//      |Dublin to Belfast = 141
//      |""".stripMargin

//  val legs = input.split("\n").toList.tail.map(parseLine).flatten
  val input = readFromFile("day9input.txt")
  val graph = buildGraph(input)
  println(graph)
  val matrix = initializeMatrix(graph)
  val result = shortestPath(matrix)
  result.foreach(arr => println(arr.mkString(", ")))
}
