package pl.blaszak.ptc.model

class Wire(input: PtcElement) extends PtcElement {

  override def getOutput(): Boolean = {
    input.getOutput()
  }

}
