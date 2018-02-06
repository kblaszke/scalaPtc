package pl.blaszak.ptc.system

import scala.collection.mutable

class AllBinaryPossibilitiesGenerator {

  def generate(inputs: List[String]): List[mutable.Map[String, Boolean]] = inputs match {
    case List() => List(mutable.Map())
    case head :: rest =>
      val restList = generate(rest)
      restList.flatMap(m => List(m ++ Map(head -> false), m ++ Map(head -> true)))
  }
}
