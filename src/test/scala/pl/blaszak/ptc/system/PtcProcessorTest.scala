package pl.blaszak.ptc.system

import org.scalatest.FunSuite
import pl.blaszak.ptc.model.{And, Or, Wire, Xor}

class PtcProcessorTest extends FunSuite {

  test("Simple OrGate test") {
    val scheduler = new PtcScheduler()
    scheduler.addInput(Map("a" -> false, "b" -> false))
    scheduler.addInput(Map("a" -> false, "b" -> true))
    scheduler.addInput(Map("a" -> true, "b" -> false))
    scheduler.addInput(Map("a" -> true, "b" -> true))
    val processor = new PtcProcessor(scheduler)
    val wireA = new Wire(processor.createInput("a"))
    val wireB = new Wire(processor.createInput("b"))
    val orGate = new Or(wireA, wireB)
    val wireS = new Wire(orGate)
    processor.registerOutput("s", wireS)
    processor.execute
  }

  test("Adder test") {
    val scheduler = new PtcScheduler()
    val processor = new PtcProcessor(scheduler)
    val wireAi = new Wire(processor.createInput("ai"))
    val wireBi = new Wire(processor.createInput("bi"))
    val wireCi = new Wire(processor.createInput("ci"))
    val gateXor1 = new Xor(wireAi, wireBi)
    val wireXor1Xor2 = new Wire(gateXor1)
    val gateXor2 = new Xor(wireXor1Xor2, wireCi)
    val wireSj = new Wire(gateXor2)
    processor.registerOutput("Sj", wireSj)
    val gateAnd3 = new And(wireCi, wireXor1Xor2)
    val wireAnd3Or5 = new Wire(gateAnd3)
    val gateAnd4 = new And(wireAi, wireBi)
    val wireAnd4Or5 = new Wire(gateAnd4)
    val gateOr5 = new Or(wireAnd3Or5, wireAnd4Or5)
    val wireCj = new Wire(gateOr5)
    processor.registerOutput("Cj", wireCj)
    scheduler.addInput(Map("ai" -> false, "bi" -> false, "ci" -> false))
    scheduler.addInput(Map("ai" -> false, "bi" -> true, "ci" -> false))
    scheduler.addInput(Map("ai" -> true, "bi" -> false, "ci" -> false))
    scheduler.addInput(Map("ai" -> true, "bi" -> true, "ci" -> false))
    scheduler.addInput(Map("ai" -> false, "bi" -> false, "ci" -> true))
    scheduler.addInput(Map("ai" -> false, "bi" -> true, "ci" -> true))
    scheduler.addInput(Map("ai" -> true, "bi" -> false, "ci" -> true))
    scheduler.addInput(Map("ai" -> true, "bi" -> true, "ci" -> true))
    processor.execute
  }

}
