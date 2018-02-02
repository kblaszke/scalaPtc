package pl.blaszak.ptc.model

class Or(inputA: PtcElement, inputB: PtcElement) extends PtcGate((a, b) => a || b)(inputA, inputB)