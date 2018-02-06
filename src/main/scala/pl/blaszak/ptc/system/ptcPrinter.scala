package pl.blaszak.ptc.system

import scala.collection.mutable

object ptcPrinter {

  private def getValue(booleanValue: Boolean): String = {
    if (booleanValue) "1"
    else "0"
  }

  private def printMap(theMap: mutable.Map[String, Boolean]): String = {
    theMap.map(k => k._1 + "=" + getValue(k._2)).mkString(" ")
  }

  def print(tests: List[(Int, mutable.Map[String, Boolean], mutable.Map[String, Boolean])]): Unit = {
    tests.foreach(t => println(f"${t._1}%5d: ${printMap(t._2)} ==>> ${printMap(t._3)}"))
  }


}
