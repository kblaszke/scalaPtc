package pl.blaszak.ptc.model

class AndGateTest extends PtcTest {

  val wireA = new Wire
  val wireB = new Wire
  val andGate = new And(wireA, wireB)

  test("0 and 0 => 0") {
    wireA.setState(false)
    wireB.setState(false)
    assert(andGate.output === false)
  }

  test("0 and 1 => 1") {
    wireA.setState(false)
    wireB.setState(true)
    assert(andGate.output === false)
  }

  test("1 and 0 => 1") {
    wireA.setState(true)
    wireB.setState(false)
    assert(andGate.output === false)
  }

  test("1 and 1 => 1") {
    wireA.setState(true)
    wireB.setState(true)
    assert(andGate.output === true)
  }
}
