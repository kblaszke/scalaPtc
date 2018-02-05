package pl.blaszak.ptc.system

trait InputsInitializer {

  def init(): Map[Int, Map[String, Boolean]]
  def getStep(): Int
}
