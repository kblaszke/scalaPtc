package pl.blaszak.ptc.model

class Xor(inputA: PtcElement, inputB: PtcElement) extends PtcGate((a, b) => (a && !b) || (b && !a))(inputA, inputB)
