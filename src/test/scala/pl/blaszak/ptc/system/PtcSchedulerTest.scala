package pl.blaszak.ptc.system

import org.scalatest.FunSuite

class PtcSchedulerTest extends FunSuite {

  test("") {
    var ptcScheduler = new PtcScheduler()
    ptcScheduler.addInput(Map("a" -> false, "b" -> false))
    ptcScheduler.addInput(Map("a" -> false, "b" -> true))
    ptcScheduler.addInput(Map("a" -> true, "b" -> true))
    for(i <- 0 until ptcScheduler.endTime by 10) {
      println(i + ": " + ptcScheduler.getInputs(i))
    }
  }

}
