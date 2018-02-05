package pl.blaszak.ptc.system

import pl.blaszak.ptc.model.{PtcElement, PtcInput}

import scala.collection.mutable

class PtcProcessor(scheduler: PtcScheduler) {

  private val inputs: mutable.HashMap[String, PtcInput] = new mutable.HashMap[String, PtcInput]
  private val outputs: mutable.HashMap[String, PtcElement] = new mutable.HashMap[String, PtcElement]

  def createInput(name: String): PtcInput = {
    val input = new PtcInput()
    inputs += (name -> input)
    input
  }

  def registerOutput(name: String, element: PtcElement): Unit = {
    outputs.put(name, element)
  }

  def execute: Unit = {
    for(time <- 0 until scheduler.getEndTime() by scheduler.getStep) {
      print(time + ":")
      inputs.foreach(inputCouple => {
        inputCouple._2.setState(scheduler.getInput(time, inputCouple._1))
        print(" " + inputCouple._1 + " = " + inputCouple._2.getOutput())
      })
      print(" =>")
      outputs.foreach(outputCouple => {
        print(" " + outputCouple._1 + " = " + outputCouple._2.getOutput())
      })
      println()

    }
  }
}
