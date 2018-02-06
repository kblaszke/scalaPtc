package pl.blaszak.ptc.system

import org.scalatest.FunSuite

class PtcSchedulerTest extends FunSuite {

  test("should init two inputs") {
    val inputsInitializer = new AllBinaryPossibilitiesInputsInitializer(List("a", "b"))
    val ptcScheduler = new PtcScheduler(inputsInitializer)
    for(i <- 0 to ptcScheduler.getEndTime by 10) {
      println(i + ": " + ptcScheduler.getInputs(i))
    }
  }

}
