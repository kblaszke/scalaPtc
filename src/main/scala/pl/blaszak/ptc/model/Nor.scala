package pl.blaszak.ptc.model

class Nor(inputA: PtcElement, inputB: PtcElement) extends PtcGate((a, b) => !(a || b))(inputA, inputB)
