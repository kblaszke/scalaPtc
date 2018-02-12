package pl.blaszak.ptc.model

class Wire(input: PtcElement) extends PtcElement {

  override def output: Boolean = {
    input.output
  }

}
