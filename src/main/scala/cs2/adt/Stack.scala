package cs2.adt

trait Stack[A] {
  def push(elem:A)
  def pop():A
  def peek():A
  def isEmpty():Boolean
}

object Stack {
  def apply[A : Manifest]():Stack[A] = new ArrayStack[A]()
}

import org.junit._
import org.junit.Assert._

class StackTester {
  var s:Stack[Int] = null
  
  @Before def initStack() {
    s = Stack[Int]()
  }
  
  @Test def checkIsEmptyWithEmpty() {
    assertTrue(s.isEmpty)
  }
  
  @Test def checkIsEmptyWithNonEmpty() {
    s.push(21)
    assertTrue(!s.isEmpty)
  }
  
  @Test def pushPopABunch() {
    for(num <- 1 to 100) {
      s.push(num)
      assertTrue(!s.isEmpty)
      assertTrue(s.peek == num)
    }
    for(num <- 100 to 1 by -1) {
      assertTrue(s.pop == num)
    }
    assertTrue(s.isEmpty)
  }
}

