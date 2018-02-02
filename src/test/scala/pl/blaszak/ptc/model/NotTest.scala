package pl.blaszak.ptc.model

import org.scalatest.FunSuite

class NotTest extends PtcTest {

  val wire = new Wire
  val not = new Not(wire)

  test("not 0 => 1") {
    wire.setState(false)
    assert(not.getOutput() === true)
  }

  test("not 1 => 0") {
    wire.setState(false)
    assert(not.getOutput() === true)
  }
}
