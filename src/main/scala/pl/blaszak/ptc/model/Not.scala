package pl.blaszak.ptc.model

class Not(input: PtcElement) extends PtcElement {
  override def output: Boolean = !input.output
}
