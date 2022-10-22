package adventofcode2015

import adventofcode2015.Day2.Box.{calculateRibbonLength, calculateWrappingPaperArea}

import scala.io.Source

object Day2 extends App {
  case class Box(l: Int, w: Int, h: Int)

  object Box {
    // TODO: refactor these functions and make them more reusable and composable
    def calculateWrappingPaperArea(box: Box): Int = {
      val sideAreas = List(2 * box.l * box.w, 2 * box.w * box.h, 2 * box.h * box.l)
      val surfaceArea = sideAreas.foldLeft(0)((totalArea, sideArea) => totalArea + sideArea)
      val smallestSideArea = sideAreas.min / 2

      surfaceArea + smallestSideArea
    }

    def calculateRibbonLength(box: Box): Int = {
      val volume = box.l * box.w * box.h
      val smallestPerimeter = List(2 * box.l + 2 * box.w, 2 * box.w + 2 * box.h, 2 * box.h + 2 * box.l).min

      volume + smallestPerimeter
    }
  }

  // TODO: handle errors with Either or Try and close file after reading
  def readBoxesFromFile(fileName: String): List[Box] = {
    val boxes = Source.fromResource(fileName).getLines.map {
      boxStr => {
        val dimensions = boxStr.split('x').toList
        dimensions match {
          case l :: w :: h :: Nil => Box(l.toInt, w.toInt, h.toInt)
          case _ => throw new Error("Input did not match shape of LxWxH")
        }
      }
    }.toList

    boxes
  }

  def getTotalArea(boxes: List[Box]): Int =
    boxes.foldLeft(0)((totalArea, box) => calculateWrappingPaperArea(box) + totalArea)

  def getTotalRibbonLength(boxes: List[Box]): Int =
    boxes.foldLeft(0)((totalLength, box) => calculateRibbonLength(box) + totalLength)

  val boxes = readBoxesFromFile("boxes.txt")

  println(getTotalArea(boxes))
  println(getTotalRibbonLength(boxes))
}
