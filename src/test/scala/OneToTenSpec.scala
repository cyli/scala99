import org.scalatest.FlatSpec
import scala.util.{Try, Success, Failure}
import OneToTen._

class OneToTenSpec extends FlatSpec {

  "last" should "return the last element of a list" in {
    val multi = last(List(1, 2, 3, 4))
    val one = last(List(1))

    assert(multi.isSuccess)
    assert(multi.get == 4)
    assert(one.isSuccess)
    assert(one.get == 1)
  }

  it should "throw NoSuchElementException if the list is empty" in {
    val fail = last(List())
    assert(fail.isFailure)

    intercept[NoSuchElementException] {
      fail.get
    }
  }

  "penultimate" should "return the next to last element of a list" in {
    val multi = penultimate(List(1, 2, 3, 4))
    val two = penultimate(List(1, 2))

    assert(multi.isSuccess)
    assert(multi.get == 3)
    assert(two.isSuccess)
    assert(two.get == 1)
  }

  it should "throw NoSuchElementException if the list has < 2 items" in {
    val empty = penultimate(List())
    assert(empty.isFailure)

    intercept[NoSuchElementException] {
      empty.get
    }

    val one = penultimate(List(1))
    assert(one.isFailure)

    intercept[NoSuchElementException] {
      one.get
    }
  }
}
