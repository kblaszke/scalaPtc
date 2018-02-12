package pl.blaszak.ptc.model

class PtcInput extends PtcElement {

  var state = false

  override def output: Boolean = {
    state
  }

  def setState(newState: Boolean): Unit = this.state = newState
}
