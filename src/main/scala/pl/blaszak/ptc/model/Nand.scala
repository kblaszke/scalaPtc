package pl.blaszak.ptc.model

class Nand(inputA: PtcElement, inputB: PtcElement) extends PtcGate((a, b) => !(a && b))(inputA, inputB)