package pl.blaszak.ptc.system

import scala.collection.mutable

class AllBinaryPossibilitiesInputsInitializer(inputs: List[String], step: Int = 10) extends AllBinaryPossibilitiesGenerator with InputsInitializer {

  override def init(): Map[Int, mutable.Map[String, Boolean]] = {
    val allPossibilities = generate(inputs)
    List.range(0, allPossibilities.size * step, step) zip allPossibilities toMap
  }

  override def getStep: Int = step
}
