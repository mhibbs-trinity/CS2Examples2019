package cs2.adt

class SingleLinkedList[A] extends List[A] {
  protected class Node(var data:A, var next:Node) {
    override def toString():String = {
      if(next == null) data.toString 
      else data.toString + "," + next.toString
    }
  }
  protected var myhead:Node = null
  protected var len:Int = 0
  
  override def toString():String = {
    if(myhead == null) "()"
    else "(" + myhead.toString + ")"
  }
  
  def toStringNonRecursive():String = {
    var res = "("
    var rover = myhead
    while(rover != null) {
      res += rover.data
      if(rover.next != null) res += ","
      rover = rover.next
    }
    res + ")"
  }
  
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

object SLLTest {
  def main(args:Array[String]) {
    var sll = new SingleLinkedList[Int]()
    sll.insert(0,5)
    sll.insert(0,8)
    sll.insert(0,7)
    println(sll.toStringNonRecursive())
  }
}



