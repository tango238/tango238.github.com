#!/usr/bin/env scalas

// @see http://eed3si9n.com/ja/scripting-with-scala

// chmod +x sample.scala
// export CONSCRIPT_OPTS="-XX:MaxPermSize=512M -Dfile.encoding=UTF-8"
// ./sample.scala

/***
scalaVersion := "2.11.7"

*/

def if2[A](cond: Boolean, onTrue: () => A, onFalse: () => A): A = {
  if(cond) onTrue() else onFalse()
}

def if3[A](cond: Boolean, onTrue: => A, onFalse: => A): A = {
  if(cond) onTrue else onFalse
}


val a = 20

if2(a < 22, () => println("true"), () => println("false"))
if3(a < 22, { println("true") }, { println("false") })


def twice(x:() => Int): Int = 2 * x()
val result = twice( () => { 1 + 2 } )
println(result)

def twice2(x: => Int): Int = 2 * x
val result2 = twice2(2)
println(result2)

def maybeTwice(b: Boolean, i: => Int):Int = {
  if(b) i+i else 0
}

val x = maybeTwice(true, { println("hi"); 1+41 })
println(x)

def maybeTwice2(b: Boolean, i: => Int):Int = {
  lazy val j = i
  if(b) j+j else 0
}

val y = maybeTwice2(true, { println("hi2"); 1+41 })
println(y)
