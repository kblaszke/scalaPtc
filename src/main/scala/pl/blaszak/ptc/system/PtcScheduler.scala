package pl.blaszak.ptc.system

import scala.collection.mutable

class PtcScheduler(step: Int = 10) {

  private var schedule: mutable.HashMap[Int, Map[String, Boolean]] = new mutable.HashMap[Int, Map[String, Boolean]]()
  var endTime = 0

  def addInput(inputs: Map[String, Boolean]): Unit = {
    schedule += (endTime -> inputs)
    endTime += step
  }

  def getInputs(time: Int): Map[String, Boolean] = {
    schedule(time)
  }

  def getInput(time: Int, inputName: String): Boolean = {
    schedule(time)(inputName)
  }

  def getStep: Int = this.step
}
