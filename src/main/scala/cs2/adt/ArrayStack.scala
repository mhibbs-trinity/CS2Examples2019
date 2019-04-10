package cs2.adt

class ArrayStack[A: Manifest] extends Stack[A] {
  private var arr: Array[A] = new Array[A](10)
  private var top: Int = -1

  def isEmpty(): Boolean = { top == -1 }

  def push(elem: A): Unit = {
    if (top == arr.length - 1) {
      val tmp = new Array[A](arr.length * 2)
      for (i <- 0 until arr.length) {
        tmp(i) = arr(i)
      }
      arr = tmp
    }
    top += 1
    arr(top) = elem
  }

  def peek(): A = { 
    if(isEmpty) throw new Exception("Can't peek an empty stack")
    arr(top)
  }

  def pop(): A = {
    if(isEmpty) throw new Exception("Can't pop from an empty stack")
    top -= 1
    arr(top+1)
  }

}