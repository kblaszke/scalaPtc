package pl.blaszak.ptc.model

class Not(input: PtcElement) extends PtcElement {
  override def getOutput: Boolean = !input.getOutput
}
