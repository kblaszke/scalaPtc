package pl.blaszak.ptc.model

class NorGateTest extends PtcTest {

  val wireA = new Wire
  val wireB = new Wire
  val norGate = new Nor(wireA, wireB)

  test("0 nor 0 => 1") {
    wireA.setState(false)
    wireB.setState(false)
    assert(norGate.getOutput() === true)
  }

  test("0 nor 1 => 0") {
    wireA.setState(false)
    wireB.setState(true)
    assert(norGate.getOutput() === false)
  }

  test("1 nor 0 => 0") {
    wireA.setState(true)
    wireB.setState(false)
    assert(norGate.getOutput() === false)
  }

  test("1 nor 1 => 0") {
    wireA.setState(true)
    wireB.setState(true)
    assert(norGate.getOutput() === false)
  }

}
