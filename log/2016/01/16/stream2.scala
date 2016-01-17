#!/usr/bin/env scalas

// @see http://eed3si9n.com/ja/scripting-with-scala

// chmod +x laziness_strem.scala
// export CONSCRIPT_OPTS="-XX:MaxPermSize=512M -Dfile.encoding=UTF-8"
// ./laziness_strem.scala

/***
scalaVersion := "2.11.7"

*/
trait Stream[+A]
case object Empty extends Stream[Nothing]
case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

object Stream {

  def cons[A](h: => A, t: => Stream[A]): Stream[A] = {
    lazy val head = h
    lazy val tail = t
    Cons(() => head, () => tail)
  }

  def empty[A]: Stream[A] = Empty

  def apply[A](as: A*): Stream[A] =
    if (as.isEmpty) empty
    else cons(as.head, apply(as.tail: _*))

  def headOption[A]: Option[A] = {
    case Empty => None
    case Cons(h, _) => h()
  }

}
