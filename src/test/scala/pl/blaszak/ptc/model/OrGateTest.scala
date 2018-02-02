package pl.blaszak.ptc.model

class OrGateTest extends PtcTest {

  val wireA = new Wire
  val wireB = new Wire
  val orGate = new Or(wireA, wireB)

  test("0 or 0 => 0") {
    wireA.setState(false)
    wireB.setState(false)
    assert(orGate.getOutput() === false)
  }

  test("0 or 1 => 1") {
    wireA.setState(false)
    wireB.setState(true)
    assert(orGate.getOutput() === true)
  }

  test("1 or 0 => 1") {
    wireA.setState(true)
    wireB.setState(false)
    assert(orGate.getOutput() === true)
  }

  test("1 or 1 => 1") {
    wireA.setState(true)
    wireB.setState(true)
    assert(orGate.getOutput() === true)
  }
}
