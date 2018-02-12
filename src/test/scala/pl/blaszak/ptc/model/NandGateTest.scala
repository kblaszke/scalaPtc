package pl.blaszak.ptc.model

class NandGateTest extends PtcTest {

  val wireA = new Wire
  val wireB = new Wire
  val nandGate = new Nand(wireA, wireB)

  test("0 nand 0 => 1") {
    wireA.setState(false)
    wireB.setState(false)
    assert(nandGate.output === true)
  }

  test("0 nand 1 => 1") {
    wireA.setState(false)
    wireB.setState(true)
    assert(nandGate.output === true)
  }

  test("1 nand 0 => 1") {
    wireA.setState(true)
    wireB.setState(false)
    assert(nandGate.output === true)
  }

  test("1 nand 1 => 0") {
    wireA.setState(true)
    wireB.setState(true)
    assert(nandGate.output === false)
  }

}
