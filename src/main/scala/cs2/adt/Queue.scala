package cs2.adt

trait Queue[A] {
  def enqueue(elem:A):Unit
  def dequeue():A
  def peek():A
  def isEmpty():Boolean
}

object Queue {
  def apply[A : Manifest]():Queue[A] = {
    new ArrayQueue[A]()
  }
}

import org.junit._
import org.junit.Assert._

class QueueTester {
  var q:Queue[Int] = null
  
  @Before def initQueue() {
    q = Queue[Int]()
  }
  
  @Test def checkMethods() {
    assertTrue(q.isEmpty)
    for(i <- 1 to 100) {
      q.enqueue(i)
      assertTrue(!q.isEmpty)
      assertTrue(q.peek() == 1)
    }
    for(i <- 1 to 100) {
      assertTrue(q.peek == i)
      assertTrue(q.dequeue == i)
    }
    assertTrue(q.isEmpty)
    for(i <- 1 to 100) {
      q.enqueue(i)
      assertTrue(!q.isEmpty)
      assertTrue(q.peek() == 1)
    }
    for(i <- 1 to 50) {
      assertTrue(q.peek == i)
      assertTrue(q.dequeue == i)
    }
    for(i <- 1 to 50) {
      q.enqueue(i)
      assertTrue(q.peek == 51)
    }
    for(i <- 51 to 100) {
      assertTrue(q.dequeue == i)
    }
    //assertTrue(q.isEmpty)
  }
  
}
















