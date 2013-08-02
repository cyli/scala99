/**
 * Problems 1-10
 */

import scala.util.{Try, Success, Failure}

object OneToTen {

  /**
   * Find the last element of a list
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

}
