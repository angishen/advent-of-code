package adventofcode2015

import scala.io.Source

/*
Because your neighbors keep defeating you in the holiday house decorating contest year after year, you've decided to deploy one million lights in a 1000x1000 grid.
Furthermore, because you've been especially nice this year, Santa has mailed you instructions on how to display the ideal lighting configuration.
Lights in your grid are numbered from 0 to 999 in each direction; the lights at each corner are at 0,0, 0,999, 999,999, and 999,0. The instructions include whether to turn on, turn off, or toggle various inclusive ranges given as coordinate pairs. Each coordinate pair represents opposite corners of a rectangle, inclusive; a coordinate pair like 0,0 through 2,2 therefore refers to 9 lights in a 3x3 square. The lights all start turned off.
To defeat your neighbors this year, all you have to do is set up your lights by doing the instructions Santa sent you in order.

After following the instructions, how many lights are lit?

You just finish implementing your winning light pattern when you realize you mistranslated Santa's message from Ancient Nordic Elvish.

The light grid you bought actually has individual brightness controls; each light can have a brightness of zero or more. The lights all start at zero.
The phrase turn on actually means that you should increase the brightness of those lights by 1.
The phrase turn off actually means that you should decrease the brightness of those lights by 1, to a minimum of zero.
The phrase toggle actually means that you should increase the brightness of those lights by 2.

What is the total brightness of all lights combined after following Santa's instructions?*/

object Day6 extends App {

  sealed abstract class Instruction(value: String)
  case object Toggle extends Instruction("toggle")
  case object TurnOn extends Instruction("turn on")
  case object TurnOff extends Instruction("turn off")

  case class Coord(x: Int, y: Int)
  case class InstructionStep(instruction: Instruction, start: Coord, end: Coord)

  sealed trait InstructionSet
  case object Part1 extends InstructionSet
  case object Part2 extends InstructionSet

  def setupLights(steps: List[InstructionStep], instructionSet: InstructionSet): Int = {
    val lightGrid = Array.ofDim[Int](1000, 1000)

    // initialize grid with zeros
    for (i <- lightGrid.indices; j <- lightGrid(0).indices) {
      lightGrid(i)(j) = 0
    }

    // fill grid
    steps.foreach {
      step => {
        for (i <- step.start.x to step.end.x; j <- step.start.y to step.end.y) {
          val light = lightGrid(i)(j)
          if (instructionSet == Part1) {
            step.instruction match {
              // You can use XOR to toggle a value!
              case Toggle => lightGrid(i)(j) ^= 1
              case TurnOn => lightGrid(i)(j) = 1
              case TurnOff => lightGrid(i)(j) = 0
            }
          } else {
            step.instruction match {
              case Toggle => lightGrid(i)(j) += 2
              case TurnOn => lightGrid(i)(j) += 1
              case TurnOff => lightGrid(i)(j) = if (light > 0) lightGrid(i)(j) - 1 else 0
            }
          }
        }
      }
    }

    val lightCount = lightGrid.foldLeft(0)(
      (totalCount, row) => {
        totalCount + row.sum
      }
    )

    lightCount
  }

  private def parseInstruction(input: String): InstructionStep = {
    val inputs = input.split(raw"\s(?=\d|t)")
    val instruction = inputs(0) match {
      case "toggle" => Toggle
      case "turn on" => TurnOn
      case "turn off" => TurnOff
    }

    val (startX, startY) = inputs(1).split(",") match {
      case Array(x, y) => (x.toInt, y.toInt)
    }

    val (endX, endY) = inputs(3).split(",") match {
      case Array(x, y) => (x.toInt, y.toInt)
    }

    InstructionStep(instruction, Coord(startX, startY), Coord(endX, endY))
  }

  private def readFromFileAndParse(fileName: String): List[InstructionStep] = {
    val rawInput = Source.fromResource(fileName).getLines().toList

    rawInput.map(parseInstruction)
  }

  val input = readFromFileAndParse("lightSteps.txt")
  println(setupLights(input, Part1))
  println(setupLights(input, Part2))
}
