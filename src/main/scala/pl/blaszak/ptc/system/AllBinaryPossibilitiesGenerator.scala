package pl.blaszak.ptc.system

class AllBinaryPossibilitiesGenerator {

  def generate(inputs: List[String]): List[Map[String, Boolean]] = inputs match {
    case List() => List()
    case head :: rest => generate(rest).flatMap(m => List(m ++ Map(head -> false), m ++ Map(head -> true)))
    }
}
