import org.scalatest.FlatSpec
import scala.util.{Try, Success, Failure}
import OneToTen._

class OneToTenSpec extends FlatSpec {

  "last" should "succeed with the last element of a list" in {
    val multi = last(List(1, 2, 3, 4))
    val one = last(List(1))

    assert(multi.isSuccess)
    assert(multi.get == 4)
    assert(one.isSuccess)
    assert(one.get == 1)
  }

  it should "fail with NoSuchElementException if the list is empty" in {
    val fail = last(List())
    assert(fail.isFailure)

    intercept[NoSuchElementException] {
      fail.get
    }
  }

  "penultimate" should "succeed with the next to last element of a list" in {
    val multi = penultimate(List(1, 2, 3, 4))
    val two = penultimate(List(1, 2))

    assert(multi.isSuccess)
    assert(multi.get == 3)
    assert(two.isSuccess)
    assert(two.get == 1)
  }

  it should "fail with NoSuchElementException if the list has < 2 items" in {
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

  "nth" should "succeed with the Kth element of a list" in {
    val first = nth(0, List(1))
    val third = nth(2, List(1, 2, 3, 4, 5))

    assert(first.isSuccess)
    assert(first.get == 1)
    assert(third.isSuccess)
    assert(third.get == 3)
  }

  it should "fail with NoSuchElementException if there is no Kth element" in {
    val empty = nth(0, List())
    assert(empty.isFailure)

    intercept[NoSuchElementException] {
      empty.get
    }

    val outOfBounds = nth(10, List(1))
    assert(outOfBounds.isFailure)

    intercept[NoSuchElementException] {
      outOfBounds.get
    }
  }

  it should "throw IllegalArgumentException if n is < 0" in {
    intercept[IllegalArgumentException] {
      nth(-5, List())
    }
  }

  "length" should "return the length of an empty list" in {
    assert(length(List()) == 0)
  }

  it should "return the length of non-empty lists" in {
    assert(length(List(1)) == 1)
    assert(length(List(1, 1, 2, 3, 5, 8)) == 6)
  }
}
