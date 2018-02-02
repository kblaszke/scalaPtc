package pl.blaszak.ptc.model

class PtcInput extends PtcElement {

  var state = false

  override def getOutput(): Boolean = {
    state
  }

  def setState(newState: Boolean) = this.state = newState
}
