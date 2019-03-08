package cs2.adt

class SingleLinkedList[A] extends List[A] {
  protected class Node(var data:A, var next:Node)
  protected var myhead:Node = null
  protected var len:Int = 0
  
  //def isEmpty():Boolean = myhead == null
  def length():Int = len
  
  private def getNodeByIndex(idx:Int):Node = {
    var rover:Node = myhead
    for(i <- 0 until idx) rover = rover.next
    rover
  }
  
  def get(idx:Int):A = getNodeByIndex(idx).data
  def set(idx:Int, elem:A):Unit = {
    getNodeByIndex(idx).data = elem
  }

  def insert(idx:Int, elem:A):Unit = {
    if(idx == 0) {
      myhead = new Node(elem, myhead)
    } else {
      val before = getNodeByIndex(idx-1)
      before.next = new Node(elem, before.next)
    }
    len += 1
  }
  
  def remove(idx:Int):A = {
    len -= 1
    if(idx == 0) {
      val tmp = myhead.data
      myhead = myhead.next
      tmp
    } else {
      val before = getNodeByIndex(idx-1)
      val tmp = before.next.data
      before.next = before.next.next
      tmp
    }
  }
  
}




