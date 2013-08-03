/**
 * Problems 1-10
 */

import scala.util.{Try, Success, Failure}

object OneToTen {

  /**
   * P01: Find the last element of a list
   *
   * {{{
   * scala> last(List(1, 1, 2, 3, 5, 8))
   * res0: Int = 8
   * }}}
   *
   * @param x A list of items to find the last element of
   * @return The last element of the list `x`
   * @throws `NoSuchElementException if the list is empty
   */
  def last[T](x: List[T]): Try[T] = {
    x match {
      case Nil => Failure(new NoSuchElementException)
      case car :: Nil => Success(car)
      case _ :: cdr => last(cdr)
    }
  }

  /**
   * P02: Find the last but one element of a list.
   *
   * {{{
   * scala> penultimate(List(1, 1, 2, 3, 5, 8))
   * res0: Int = 5
   * }}}
   *
   * @param x A list of items to find the next to last element of
   * @return The penultimate element of the list `x`
   * @throws `NoSuchElementException` if the list is less than 2 elements long
   */
  def penultimate[T](x: List[T]): Try[T] = {
    x match {
      case Nil => Failure(new NoSuchElementException)
      case car :: _ :: Nil => Success(car)
      case _ :: cdr => penultimate(cdr)
    }
  }

  /**
   * P03: Find the Kth element of a list.
   * By convention, the first element in the list is element 0.
   *
   * {{{
   * scala> nth(2, List(1, 1, 2, 3, 5, 8))
   * res0: Int = 2
   * }}}
   *
   * @param x A list of items to find the next to Kth element of
   * @return The Kth element of the list `x`
   * @throws `IllegalArgumentException` if n < 0
   * @throws `NoSuchElementException` if there is no Kth element in the list
   */
  def nth[T](n: Int, x: List[T]): Try[T] => {
  }
}
