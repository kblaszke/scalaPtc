package pl.blaszak.ptc.model

class And(inputA: PtcElement, inputB: PtcElement) extends PtcGate((a, b) => a && b)(inputA, inputB)
