package pl.blaszak.ptc.model

class PtcGate(f: (Boolean, Boolean) => Boolean)(inputA: PtcElement, inputB: PtcElement) extends PtcElement {

  override def output: Boolean = {
    f(inputA.output, inputB.output)
  }
}
