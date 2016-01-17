#!/usr/bin/env scalas

// @see http://eed3si9n.com/ja/scripting-with-scala

// chmod +x laziness_strem.scala
// export CONSCRIPT_OPTS="-XX:MaxPermSize=512M -Dfile.encoding=UTF-8"
// ./laziness_strem.scala

/***
scalaVersion := "2.11.7"

*/

sealed trait Stream[+A] {

  def headOption: Option[A] = this match {
    case Empty => None
    case Cons(h, _) => Some(h())
  }

}
case object Empty extends Stream[Nothing]
case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]


val x = Cons(() => { println("hoge"); 12}, () => Empty)
val h1 = x.headOption
val h2 = x.headOption
