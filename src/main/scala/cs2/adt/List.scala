package cs2.adt

trait List[A] {
  def get(idx:Int):A
  def set(idx:Int, elem:A)
  def insert(idx:Int, elem:A)
  def remove(idx:Int):A
  
  //def isEmpty():Boolean
  def length():Int
  
  def prepend(elem:A) = insert(0,elem)
  def append(elem:A) = insert(length,elem)
  def apply(idx:Int):A = get(idx)
  def update(idx:Int, elem:A) = set(idx,elem)
}

object List {
  def apply[A]():List[A] = new SingleLinkedList[A]() 
}

import org.junit._
import org.junit.Assert._

class ListTester {
  var lst = List[Int]()
  
  @Before def initList() {
    lst = List[Int]()
  }
  
  @Test def testMethods() {
    lst.insert(0,1)
    lst.insert(1,2)
    lst.insert(2,3)
    for(i <- 0 to 2) {
      assertTrue(lst.get(i) == i+1)
    }
    for(i <- 0 to 2) {
      lst.set(i, i*3)
      assertTrue(lst.get(i) == i*3)
    }
    lst.remove(0)
    assertTrue(lst.get(0) == 3)
    lst.remove(1)
    assertTrue(lst.length() == 1)
    lst.remove(0)
    //assertTrue(lst.isEmpty())
  }
  
  
  
}






