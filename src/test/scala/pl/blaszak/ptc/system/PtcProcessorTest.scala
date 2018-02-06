package pl.blaszak.ptc.system

import org.scalatest.FunSuite
import pl.blaszak.ptc.model.{And, Or, Wire, Xor}

class PtcProcessorTest extends FunSuite {

  test("Simple OrGate test") {
    val scheduler = new PtcScheduler(new AllBinaryPossibilitiesInputsInitializer(List("a", "b")))
    val processor = new PtcProcessor(scheduler)
    val wireA = new Wire(processor.createInput("a"))
    val wireB = new Wire(processor.createInput("b"))
    val orGate = new Or(wireA, wireB)
    val wireS = new Wire(orGate)
    processor.registerOutput("s", wireS)
    processor.execute
  }

  test("Adder test") {
    val scheduler = new PtcScheduler(new AllBinaryPossibilitiesInputsInitializer(List("ai", "bi", "ci")))
    val processor = new PtcProcessor(scheduler)
    val wireCi = new Wire(processor.createInput("ci"))
    val wireBi = new Wire(processor.createInput("bi"))
    val wireAi = new Wire(processor.createInput("ai"))
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
    val result = processor.execute
    // result.foreach(test => println(test._1 + ": " + test._2 + " ==>> " + test._3))
    ptcPrinter.print(result)
  }

}
