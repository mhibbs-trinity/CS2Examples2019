package cs2.adt

class DoubleLinkedList[A : Manifest] extends List[A] {
  private class Node(var data:A, var prev:Node, var next:Node)
  
  private var sentinel:Node = new Node(new Array[A](1)(0),null,null)
  sentinel.prev = sentinel
  sentinel.next = sentinel
  
  private var len = 0
  
  private def getNodeByIndex(idx:Int):Node = {
    if(idx < 0 || idx >= len) {
      sentinel
    } else {
      var rover:Node = sentinel.next
      for(i <- 0 until idx) rover = rover.next
      rover
    }
  }
  
  def get(idx:Int):A = getNodeByIndex(idx).data
  def set(idx:Int, elem:A):Unit = getNodeByIndex(idx).data = elem
  
  def insert(idx:Int, elem:A):Unit = {
    val rover = getNodeByIndex(idx-1)
    rover.next = new Node(elem, rover, rover.next)
    rover.next.next.prev = rover.next
    len += 1
  }
  def remove(idx:Int):A = {
    val rover = getNodeByIndex(idx)
    rover.prev.next = rover.next
    rover.next.prev = rover.prev
    len -= 1
    rover.data
  }
  
  def length():Int = len
}





