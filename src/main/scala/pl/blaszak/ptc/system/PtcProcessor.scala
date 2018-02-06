package pl.blaszak.ptc.system

import pl.blaszak.ptc.model.{PtcElement, PtcInput}

import scala.collection.mutable

class PtcProcessor(scheduler: PtcScheduler) {

  private val inputs: mutable.Map[String, PtcInput] = new mutable.HashMap[String, PtcInput]
  private val outputs: mutable.Map[String, PtcElement] = new mutable.HashMap[String, PtcElement]

  def createInput(name: String): PtcInput = {
    val input = new PtcInput()
    inputs += (name -> input)
    input
  }

  def registerOutput(name: String, element: PtcElement): Unit = {
    outputs.put(name, element)
  }

  def setInputs(inputStates: mutable.Map[String, Boolean]) = {
    inputs.foreach(input => input._2.setState(inputStates(input._1)))
  }

  def execute: List[(Int, mutable.Map[String, Boolean], mutable.Map[String, Boolean])] = {
    val results = List.range(0, scheduler.getEndTime(), scheduler.getStep())
      .map(time => {
        val inputsState = scheduler.getInputs(time)
        setInputs(inputsState)
        val outputsState = outputs.map(output => (output._1, output._2.getOutput()))
        (time, inputsState, outputsState)
      })
    results
  }
}
