package pl.blaszak.ptc.model

class XnorGateTest extends PtcTest {

  val wireA = new Wire
  val wireB = new Wire
  val xnorGate = new Xnor(wireA, wireB)

  test("0 xnor 0 => 1") {
    wireA.setState(false)
    wireB.setState(false)
    assert(xnorGate.getOutput() === true)
  }

  test("0 xnor 1 => 0") {
    wireA.setState(false)
    wireB.setState(true)
    assert(xnorGate.getOutput() === false)
  }

  test("1 xnor 0 => 0") {
    wireA.setState(true)
    wireB.setState(false)
    assert(xnorGate.getOutput() === false)
  }

  test("1 xnor 1 => 1") {
    wireA.setState(true)
    wireB.setState(true)
    assert(xnorGate.getOutput() === true)
  }

}
