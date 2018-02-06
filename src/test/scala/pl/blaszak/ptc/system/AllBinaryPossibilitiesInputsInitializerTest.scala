package pl.blaszak.ptc.system

import org.scalatest.FunSuite

class AllBinaryPossibilitiesInputsInitializerTest extends FunSuite {

  test("should generate empty result for empty input") {
    val inputs = List()
    val inputsInitializer = new AllBinaryPossibilitiesInputsInitializer(inputs)
    val result = inputsInitializer.generate(inputs)
    assert(result === List())
  }

  test("should generate all possibilities for one input") {
    val inputs = List("a")
    val inputsInitializer = new AllBinaryPossibilitiesInputsInitializer(inputs)
    val result = inputsInitializer.generate(inputs)
    assert(result.size === 2)
  }

  test("should generate all possibilities for two inputs") {
    val inputs = List("a", "b")
    val inputsInitializer = new AllBinaryPossibilitiesInputsInitializer(inputs)
    val result = inputsInitializer.generate(inputs)
    assert(result.size === 4)
  }

  test("shoud init two inputs") {
    val initializer = new AllBinaryPossibilitiesInputsInitializer(List("a", "b"))
    val result = initializer.init()
    assert(result.size === 4)
  }
}
