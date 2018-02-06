package pl.blaszak.ptc.system

import scala.collection.mutable

class PtcScheduler(inputsInitializer: InputsInitializer) {

  private val schedule: Map[Int, mutable.Map[String, Boolean]] = inputsInitializer.init()

  def getInputs(time: Int): mutable.Map[String, Boolean] = {
    schedule(time)
  }

  def getInput(time: Int, inputName: String): Boolean = {
    schedule(time)(inputName)
  }

  def getStep(): Int = inputsInitializer.getStep()

  def getEndTime(): Int = schedule.keySet.max
}
