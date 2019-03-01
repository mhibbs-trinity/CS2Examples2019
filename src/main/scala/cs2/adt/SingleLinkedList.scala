package cs2.adt

class SingleLinkedList[A] extends List[A] {
  private class Node(var data:A, var next:Node)
  private var head:Node = null
  
  def isEmpty():Boolean = head == null
  //def length():Int = 
  
  private def getNodeByIndex(idx:Int):Node = {
    var rover:Node = head
    for(i <- 0 until idx) rover = rover.next
    rover
  }
  
  def get(idx:Int):A = getNodeByIndex(idx).data
  def set(idx:Int, elem:A):Unit = {
    getNodeByIndex(idx).data = elem
  }

  def insert(idx:Int, elem:A):Unit = {
    if(idx == 0) {
      head = new Node(elem, head) 
    } else {
      val before = getNodeByIndex(idx-1)
      before.next = new Node(elem, before.next)
    }
  }
  
  def remove(idx:Int):A = {
    if(idx == 0) {
      val tmp = head.data
      head = head.next
      tmp
    } else {
      val before = getNodeByIndex(idx-1)
      val tmp = before.next.data
      before.next = before.next.next
      tmp
    }
  }
  
}




