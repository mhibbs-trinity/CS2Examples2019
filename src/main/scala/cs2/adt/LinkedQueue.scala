package cs2.adt

class LinkedQueue[A] extends Queue[A] {
  private class Node(var data:A, var next:Node)
  
  private var head:Node = null
  private var tail:Node = null
  
  def isEmpty():Boolean = head == null
  def peek():A = head.data
  
  def enqueue(elem:A):Unit = {
    if(isEmpty) {
      tail = new Node(elem, null)
      head = tail
    } else {
      tail.next = new Node(elem, null)
      tail = tail.next
    }
  }
  
  def dequeue():A = {
    val tmp = head.data
    head = head.next
    if(head == null) tail = null
    tmp
  }
}



