package cs2.adt

class LinkedPriorityQueue[A <% Ordered[A]]
          extends PriorityQueue[A] {
  
  private class Node(val data:A, var next:Node) 
  private var head:Node = null
  
  /*
  def add(elem:A):Unit = {
    head = new Node(elem,head)
  }
  def peek():A = {
    var bigNode = head
    var rover = head
    while(rover != null) {
      if(rover.data > bigNode.data) {
        bigNode = rover
      }
      rover = rover.next
    }
    bigNode.data
  }
  def get():A = {
    var beforeBigNode = head
    var rover = head
    while(rover.next != null) {
      if(rover.next.data > beforeBigNode.next.data) {
        beforeBigNode = rover
      }
      rover = rover.next
    }
    if(beforeBigNode.next.data > head.data) {
      val tmp = beforeBigNode.next.data
      beforeBigNode.next = beforeBigNode.next.next
      tmp
    }
    else {
      val tmp = head.data
      head = head.next
      tmp
    }
  }*/
  def isEmpty():Boolean = head == null
  
  def peek():A = head.data
  def get():A = {
    val tmp = head.data
    head = head.next
    tmp
  }
  def add(elem:A):Unit = {
    if(head == null || elem > head.data) {
      head = new Node(elem,head)
    } else {
      var rover = head
      while(rover.next != null && elem < rover.next.data) {
        rover = rover.next
      }
      rover.next = new Node(elem, rover.next)
    }
  }
  
  
  
  
}



