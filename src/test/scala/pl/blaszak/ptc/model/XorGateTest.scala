package pl.blaszak.ptc.model

class XorGateTest extends PtcTest {

  val wireA = new Wire
  val wireB = new Wire
  val xorGate = new Xor(wireA, wireB)

  test("0 xor 0 => 0") {
    wireA.setState(false)
    wireB.setState(false)
    assert(xorGate.getOutput() === false)
  }

  test("0 xor 1 => 1") {
    wireA.setState(false)
    wireB.setState(true)
    assert(xorGate.getOutput() === true)
  }

  test("1 xor 0 => 1") {
    wireA.setState(true)
    wireB.setState(false)
    assert(xorGate.getOutput() === true)
  }

  test("1 xor 1 => 0") {
    wireA.setState(true)
    wireB.setState(true)
    assert(xorGate.getOutput() === false)
  }
}
