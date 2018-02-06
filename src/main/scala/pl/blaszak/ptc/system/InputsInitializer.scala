package pl.blaszak.ptc.system

import scala.collection.mutable

trait InputsInitializer {

  def init(): Map[Int, mutable.Map[String, Boolean]]
  def getStep: Int
}
