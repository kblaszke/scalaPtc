package pl.blaszak.ptc.model

class PtcGate(f: (Boolean, Boolean) => Boolean)(inputA: PtcElement, inputB: PtcElement) extends PtcElement {

  override def getOutput(): Boolean = {
    f(inputA.getOutput(), inputB.getOutput())
  }
}
