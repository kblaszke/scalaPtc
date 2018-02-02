package pl.blaszak.ptc.system

class PtcTimer(step: Int = 10) {

  var time: Int = 0

  def ++ = {
    time += 1
  }
}
