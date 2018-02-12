package pl.blaszak.ptc.model

import org.scalatest.FunSuite

abstract class PtcTest extends FunSuite {

  class Wire extends PtcElement {
    private var state = false
    def setState(state: Boolean): Unit = {
      this.state = state
    }
    override def output: Boolean = state
  }
}
