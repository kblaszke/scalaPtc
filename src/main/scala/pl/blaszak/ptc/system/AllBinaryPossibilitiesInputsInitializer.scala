package pl.blaszak.ptc.system

class AllBinaryPossibilitiesInputsInitializer(inputs: List[String], step: Int = 10) extends AllBinaryPossibilitiesGenerator with InputsInitializer {

  override def init(): Map[Int, Map[String, Boolean]] = {
    List.range(0, inputs.size * step, step) zip generate(inputs) toMap
  }

  override def getStep(): Int = step
}
